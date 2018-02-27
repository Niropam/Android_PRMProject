package com.example.user.project;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ActionMode;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class ViewProfile extends AppCompatActivity implements View.OnClickListener{
    TextView name,father,mother,address,nationality,iD,location,bdates,genders;
    Button Click;


        //UPLOAD
        private static final int SELECT_PICTURE = 100;
        private static final String TAG = "ImagePicker";

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_view_profile);
            findViewById(R.id.btnSelectImage).setOnClickListener(this);

            name = (TextView) findViewById(R.id.nameV);
            father = (TextView) findViewById(R.id.fnameV);
            mother = (TextView) findViewById(R.id.mnameV);
            address=(TextView) findViewById(R.id.addressV);
            nationality=(TextView) findViewById(R.id.nationalityV);
            iD=(TextView) findViewById(R.id.nationalIdV);
            location=(TextView) findViewById(R.id.currentLocationV);
            bdates = (TextView) findViewById(R.id.birthdayView2);
            genders=(TextView) findViewById(R.id.genderV);


            //get data from mainActivity via BUNDLE
            Bundle bundle= getIntent().getExtras();
            String viewName=bundle.getString("Name");
            String viewFather=bundle.getString("Father");
            String viewMother=bundle.getString("Mother");
            String viewBdate=bundle.getString("Bdate");
            String viewGender=bundle.getString("Gender");
            String viewAddress=bundle.getString("Address");
            String viewNationality=bundle.getString("Nationality");
            String viewNationalID=bundle.getString("NationalID");
            String viewLocation=bundle.getString("Location");


            //show these data
            name.setText(viewName);
            father.setText(viewFather);
            mother.setText(viewMother);
            bdates.setText(viewBdate);
            genders.setText(viewGender);
            address.setText(viewAddress);
            nationality.setText(viewNationality);
            iD.setText(viewNationalID);
            location.setText(viewLocation);
        }

    /* Choose an image from Gallery */
    void openImageChooser() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), SELECT_PICTURE);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            if (requestCode == SELECT_PICTURE) {
                // Get the url from data
                Uri selectedImageUri = data.getData();
                if (null != selectedImageUri) {
                    // Get the path from the Uri
                    String path = getPathFromURI(selectedImageUri);
                    Log.i(TAG, "Image Path : " + path);
                    // Set the image in ImageView
                    ((ImageView) findViewById(R.id.imgView)).setImageURI(selectedImageUri);
                }
            }
        }
    }

    /* Get the real path from the URI */
    public String getPathFromURI(Uri contentUri) {
        String res = null;
        String[] proj = {MediaStore.Images.Media.DATA};
        Cursor cursor = getContentResolver().query(contentUri, proj, null, null, null);
        if (cursor.moveToFirst()) {
            int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            res = cursor.getString(column_index);
        }
        cursor.close();
        return res;
    }

    @SuppressLint("NewApi")
    public static String getPathAPI19(Context context, Uri uri) {
        String filePath = "";
        String fileId = DocumentsContract.getDocumentId(uri);
        // Split at colon, use second item in the array
        String id = fileId.split(":")[1];
        String[] column = {MediaStore.Images.Media.DATA};
        String selector = MediaStore.Images.Media._ID + "=?";
        Cursor cursor = context.getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                column, selector, new String[]{id}, null);
        int columnIndex = cursor.getColumnIndex(column[0]);
        if (cursor.moveToFirst()) {
            filePath = cursor.getString(columnIndex);
        }
        cursor.close();
        return filePath;
    }
    @Override
    public void onClick(View v) {
        openImageChooser();
    }


    public void clickP(View callBack) {
        Intent i = new Intent(ViewProfile.this,MainActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);
    }

}

