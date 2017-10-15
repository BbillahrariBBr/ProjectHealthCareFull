package com.collegeproject.dev3dot.projecthealthcare;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;



public class CustomAdapterEmergency extends BaseAdapter {
    Context con;
    List<EmergencyRowItem> emergencyRowItems;

    public CustomAdapterEmergency(Context con, List<EmergencyRowItem> emergencyRowItems) {
        this.con = con;
        this.emergencyRowItems = emergencyRowItems;
    }

    @Override
    public int getCount() {
        return emergencyRowItems.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup viewGroup) {

        ViewHolder holder = null;
        LayoutInflater inflater = (LayoutInflater) con.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.emergency_list_item, null);
            holder = new ViewHolder();

            holder.emergencyName = (TextView) convertView.findViewById(R.id.textViewName);
            holder.emergencyPlace = (TextView) convertView.findViewById(R.id.textViewPlace);
            holder.emergencyNumber = (TextView) convertView.findViewById(R.id.textViewPhone);
            holder.calliV = (ImageView) convertView.findViewById(R.id.emergencyCall_iv);

            EmergencyRowItem emergencyPosition = emergencyRowItems.get(position);

            holder.emergencyName.setText(emergencyPosition.getEmergencyName());
            holder.emergencyPlace.setText(emergencyPosition.getEmergencyPlace());
            holder.emergencyNumber.setText(emergencyPosition.getEmergencyPhNumber());

            final String num = emergencyPosition.getEmergencyPhNumber();

            holder.calliV.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent in = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + num));
                    con.startActivity(in);
                }
            });


            //  You can use following for direct call, but u have to give permission on manifest
            //  <uses-permission android:name="android.permission.CALL_PHONE"/>

//            holder.calliV.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    Intent in = new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+num));
//                    con.startActivity(in);
//                }
//            });


            //Or you can use the folklowing
//            holder.calliV.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    Intent in = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + num));
//                    if (ActivityCompat.checkSelfPermission(con, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
//                        // TODO: Consider calling
//                        //    ActivityCompat#requestPermissions
//                        // here to request the missing permissions, and then overriding
//                        //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
//                        //                                          int[] grantResults)
//                        // to handle the case where the user grants the permission. See the documentation
//                        // for ActivityCompat#requestPermissions for more details.
//                        return;
//                    }
//                    con.startActivity(in);
//                }
//            });

        }
        return convertView;
    }

    public class ViewHolder {
        TextView emergencyName;
        TextView emergencyPlace;
        TextView emergencyNumber;

        ImageView calliV;
    }
}

