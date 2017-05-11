package com.cs60333.kgifaldi.lab2_kgifaldi;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.cs60333.kgifaldi.lab2_kgifaldi.R;

import org.w3c.dom.Text;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Kyle on 2/15/2017.
 */
public class DetailActivity extends Activity {
    Button button;
    private static final int CAMERA_REQUEST = 1888;
    @Override
    public void onCreate(Bundle bundle){
                         //     index#:    0                        1           2                                                               3       4                 5            6        7          8            9                 10      11
      //  String[] details = new String[]{"February 11", "Flordia State", "Seminoles", "(21-5)", "fs.png",  "72 - 84"};
      //  String[] details = getIntent().getStringArrayExtra("Team");
        Team team = (Team) getIntent().getSerializableExtra("team");
       // MyCsvFileReader team = new MyCsvFileReader(this.getApplicationContext());
        //ArrayList<Team> teamList = team.readCsvFile(R.raw.schedule);


        super.onCreate(bundle);
        setContentView(R.layout.activity_detail);

        TextView gameDate = (TextView) findViewById(R.id.date);
        TextView gameTime = (TextView) findViewById(R.id.time);
        TextView gameLocation = (TextView) findViewById(R.id.location);
        ImageView leftTeamLogo = (ImageView) findViewById(R.id.leftTeamLogo);
        TextView leftTeamName = (TextView) findViewById(R.id.leftTeamName);
        TextView leftTeamMascot = (TextView) findViewById(R.id.leftTeamMascot);
        TextView leftTeamRecord = (TextView) findViewById(R.id.leftTeamRecord);
        ImageView rightTeamLogo = (ImageView) findViewById(R.id.rightTeamLogo);
        TextView rightTeamName = (TextView) findViewById(R.id.rightTeamName);
        TextView rightTeamMascot = (TextView) findViewById(R.id.rightTeamMascot);
        TextView rightTeamRecord = (TextView) findViewById(R.id.rightTeamRecord);
        TextView finalScore = (TextView) findViewById(R.id.finalScore);

  /*      String mDrawableName1 = details[3];
        int resID_1 = getContext().getResources().getIdentifier(mDrawableName1, "drawable", getContext().getPackageName());
        leftTeamLogo.setImageResource(resID_1);
        String mDrawableName2 = details[7];
        int resID_2 = getContext().getResources().getIdentifier(mDrawableName2, "drawable", getContext().getPackageName());
        rightTeamLogo.setImageResource(resID_2);


image, name. date, masot, record, score
*/

        Context context = leftTeamLogo.getContext();
        int id = context.getResources().getIdentifier(team.getTeamLogo(), "drawable", context.getPackageName());
        leftTeamLogo.setImageResource(id);

        rightTeamLogo.setImageResource(R.drawable.lep);


        gameDate.setText(team.getTeamMascot());
        gameTime.setText(R.string.time);
        gameLocation.setText(R.string.location);
       // leftTeamLogo.setText(details[3]);
        leftTeamName.setText(team.getTeamName());
        leftTeamMascot.setText(team.getTeamMascot());
        leftTeamRecord.setText(team.getTeamRecord());
       // rightTeamLogo.setText(details[7]);
        rightTeamName.setText(R.string.school);
        rightTeamMascot.setText(R.string.mascot);
        rightTeamRecord.setText(R.string.record);
        finalScore.setText(team.getFinalScore());

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                File PictureDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
                String pictureName = getPictureName();
                File imageFile = new File(PictureDirectory, pictureName);
                Uri pictureUri = Uri.fromFile(imageFile);
                cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, pictureUri);
                startActivityForResult(cameraIntent, CAMERA_REQUEST);
            }

            private String getPictureName() {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
                String timestamp = sdf.format(new Date());
                return "BestMoments" + timestamp + ".jpg";
            }

            protected void onActivityResult(int requestCode, int resultCode, Intent data) {
                if (resultCode == RESULT_OK) {
                    if (requestCode == CAMERA_REQUEST) {
                        Intent photoGalleryIntent = new Intent(Intent.ACTION_PICK);
                        File pictureDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);

                        String pictureDirectoryPath = pictureDirectory.getPath();
                        Uri imageUri = Uri.parse(pictureDirectoryPath);
                        InputStream inputStream;
                        try {
                            inputStream = getContentResolver().openInputStream(imageUri);

                            Bitmap image = BitmapFactory.decodeStream(inputStream);
                            ImageView imgView = (ImageView) findViewById(R.id.photo_taken);
                            imgView.setImageBitmap(image);

                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                    }
                }


            }
        });

    }

}
