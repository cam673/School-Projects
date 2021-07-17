//Christopher Masferrer
//011894127
//CECS 424

using System;
using System.IO;
using System.Linq;
using System.Collections.Generic;
using System.Xml;
using System.Xml.Linq;

namespace C_Sharp
{
    class LINQ
    {
        //look through the file directory
        /*********/
        static IEnumerable<string> EnumerateFilesRecursively(string path)
        {
            foreach (string p in Directory.EnumerateFiles(path))
            {
                foreach(string s in Directory.EnumerateFiles(p))
                {
                    yield return s;
                }
            }
        }

        //return the appropriate byte format when a size is entered
        static string FormatByteSize(long byteSize)
        {
            //string output, power incrementer, convert long to double
            string bSize;
            int byteCount = 0;
            double bytes = Convert.ToDouble(byteSize);

            //Verify power size and reduce the value
            if(bytes > 1000)
            {
                while (bytes > 1000)
                {
                    bytes = bytes/1000;
                    byteCount = byteCount + 1;
                }
            }

            //round up the value up two decimal places
            bytes = Math.Round(bytes, 2);

            //based on the power level, enter the appropriate size to bSize
            switch (byteCount)
            {
                case 0:
                    bSize = bytes + "B";
                     break;
                case 1:
                    bSize = bytes + "kB";
                     break;
                case 2:
                    bSize = bytes + "MB";
                     break;
                case 3:
                    bSize = bytes + "GB";
                     break;
                case 4:
                    bSize = bytes + "TB";
                     break;
                case 5:
                    bSize = bytes + "PB";
                     break;
                case 6:
                    bSize = bytes + "EB";
                     break;
                case 7:
                    bSize = bytes + "ZB";
                     break;
                default:
                    bSize = bytes + "B";
                     break;
        }

        //return the size
        return bSize;
  }

  //create the report
  //
  static XDocument CreateReport (IEnumerable<string> files)
  =>
    new XDocument(
      new XDocumentType("html", null, null, null),
      new XElement("html", 
        new XElement("head", 
          new XElement("title", "File Report"), 
          new XElement("style", "table, th, td { border: 1px solid black; }")
        ),
        new XElement("body", 
          new XElement("table",
            new XElement("thread",
              new XElement("tr", 
                new XElement("th", "Type"),
                new XElement("th", "Count"),
                new XElement("th", "Total Size")
              )
            ),
            new XElement("tBody",
              from file in files
              group file by Path.GetExtension(file).ToLower() into fileGroup
              let totalSize = fileGroup.Sum(file => new FileInfo(file).Length)
              orderby totalSize descending
              select new XElement("tr",
                new XElement("td", fileGroup.Key),
                new XElement("td", fileGroup.Count()),
                new XElement("td", FormatByteSize(totalSize))
              )
            )
          )
        )
      )
    );
  

  //generate a report and save it to the specified path
  public static void Main(string[] args) 
  {
    //main program
    try
    {
        string folder = args[0];
        string htmlReport = args[1];
        CreateReport(EnumerateFilesRecursively(folder)).Save(htmlReport);
    }
    catch
    {
        Console.WriteLine("Error: Enter the folder path, then the name of the report");
    }
    
  }
    }
}