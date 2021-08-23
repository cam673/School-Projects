//Christopher Masferrer
//011894127
package com.example.homework3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.maps.CameraUpdateFactory;

import java.util.LinkedList;

//adapter for the street recycler view
public class StreetListAdapter extends RecyclerView.Adapter<StreetListAdapter.StreetViewHolder>
{
    private final LinkedList<String> streetList;
    private final LayoutInflater sInflater;


    class StreetViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        public final TextView streetItemView;
        final StreetListAdapter sAdapter;

        public StreetViewHolder(View itemView, StreetListAdapter adapter)
        {
            super(itemView);
            streetItemView = (TextView) itemView.findViewById(R.id.street);
            this.sAdapter = adapter;
            itemView.setOnClickListener(this);
        }

        //on click move the camera to the address' coordinates
        @Override
        public void onClick(View v)
        {
            int position = getAdapterPosition();
            Coordinates.mMap.animateCamera(CameraUpdateFactory.newLatLng(Coordinates.coordinates.get(position)));
        }
    }

    public StreetListAdapter(Context context, LinkedList<String> sList)
    {
        sInflater = LayoutInflater.from(context);
        this.streetList = sList;
    }

    @Override
    public StreetViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View itemView = sInflater.inflate(R.layout.streetlist_item, parent, false);
        return new StreetViewHolder(itemView, this);
    }

    @Override
    public void onBindViewHolder(StreetViewHolder holder, int position)
    {
        String current = streetList.get(position);
        holder.streetItemView.setText(current);
    }

    @Override
    public int getItemCount()
    {
        return streetList.size();
    }

    @Override
    public long getItemId(int position)
    {
        return super.getItemId(position);
    }

    @Override
    public int getItemViewType(int position)
    {
        return super.getItemViewType(position);
    }

}
