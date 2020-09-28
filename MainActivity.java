package My.Gslc;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText namaDpn, namaBlkng, pass;
    RadioGroup gr;
    RadioButton female, male;
    Button save;

    public void init(){
        namaDpn = findViewById(R.id.txt_namaDpn);
        namaBlkng = findViewById(R.id.txt_namaBlkg);
        pass = findViewById(R.id.txt_pass);
        gr = findViewById(R.id.radio_gr);
        female = findViewById(R.id.female_gr);
        male = findViewById(R.id.male_gr);
        save = findViewById(R.id.btn_save);
    }

    public boolean checkPass(){
        boolean passInt = false;
        boolean passStr = false;

        for (int i=0; i<pass.length(); i++){
            if ((pass.getText().charAt(i) >= 'a' && pass.getText().charAt(i) <= 'z')
                    || (pass.getText().charAt(i) >= 'A' && pass.getText().charAt(i) <= 'Z') ){
                passStr = true;
            }
            if (pass.getText().charAt(i) >= '0' && pass.getText().charAt(i) <= '9'){
                passInt = true;
            }
        }
        if(passStr == true && passInt == true){
            return true;
        }
        return false;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        checkPass();

        save.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_save :
                checkPass();
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);

                if( namaDpn.getText().length()==0){
                    alertDialog.setMessage("Nama Depan harus diisi");
                    alertDialog.show();
                }else if (namaBlkng.getText().length()==0){
                    alertDialog.setMessage("Nama Belakang harus diisi");
                    alertDialog.show();
                }else if(pass.getText().length()==0){
                    alertDialog.setMessage("Password harus diisi");
                    alertDialog.show();
                }else if (pass.getText().length()<8 || pass.getText().length()>25){
                    alertDialog.setMessage("Password range 8-25");
                    alertDialog.show();
                }else if (checkPass()==false){
                    alertDialog.setMessage("Password harus campuran Huruf dan Angka ");
                    alertDialog.show();
                }else if (!female.isChecked() && !male.isChecked()){
                    alertDialog.setMessage("gender harus diisi");
                    alertDialog.show();
                }else{
                    alertDialog.setMessage("terima kasih :DD");
                    alertDialog.show();

                    namaDpn.setText("");
                    namaBlkng.setText("");
                    pass.setText("");
                    gr.clearCheck();
                }
                break;
        }
    }
}