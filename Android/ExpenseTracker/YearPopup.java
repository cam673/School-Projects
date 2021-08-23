package com.example.expensetracker;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

//displays a popup message when the add year button is clicked
public class YearPopup extends AppCompatDialogFragment
{
    private EditText year, income, savings;
    private YearPopupListener listener;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.year_add_popup, null);

        builder.setView(view)
                .setTitle("Add an expense tracking year")
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                        //dismiss
                    }
                })
                .setPositiveButton("Ok", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                        String newYear = year.getText().toString().trim();
                        String newIncome = income.getText().toString().trim();
                        String newSavings = savings.getText().toString().trim();
                        int yearConvert = Integer.parseInt(newYear);
                        double incomeConvert = Double.parseDouble(newIncome);
                        double savingsConvert = Double.parseDouble(newSavings);
                        listener.applyText(yearConvert, incomeConvert, savingsConvert);
                    }
                });

        year = view.findViewById(R.id.edit_year);
        income = view.findViewById(R.id.edit_income);
        savings = view.findViewById(R.id.edit_savings);

        return builder.create();
    }

    @Override
    public void onAttach(Context context)
    {
        super.onAttach(context);

        try
        {
            listener = (YearPopupListener) context;
        }
        catch(ClassCastException e)
        {
            throw new ClassCastException(context.toString() + "must implement YearPopupListener");
        }
    }

    //interface for the DataSelect class to use
    public interface YearPopupListener
    {
        void applyText(int yearSubmit, double incomeSubmit, double savingsSubmit);
    }
}
