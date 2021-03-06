package ness.edu.firebasedatabase;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

/**
 * Created by Android2017 on 6/30/2017.
 */

public class BaseFragment extends Fragment{

    protected AlertDialog dialog; //null
    private boolean isShowing;

    //Lazy loading.
    protected void showProgress(boolean show){
        if (dialog == null){
            dialog = new AlertDialog.Builder(getContext()).
                    setTitle("Please wait").
                    create();
        }

        if (show && !isShowing) {
            isShowing = true;
            dialog.show();
        }
        else if(!show && isShowing){
            isShowing = false;
            dialog.dismiss();
        }
    }

    protected void hideKeyboard(){
        //get a system service called imm (input method manager)
        //LayoutInflaterService
        InputMethodManager imm = (InputMethodManager)
                getContext().getSystemService(Context.INPUT_METHOD_SERVICE);

        //0 == FORCE HIDE... Show params can be anything but 0.

        imm.toggleSoftInput(InputMethodManager.SHOW_IMPLICIT, 0);

//        EditText et = new EditText(getContext());
//        if (et.getWindowToken() != null)
//        imm.toggleSoftInputFromWindow(et.getWindowToken(), InputMethodManager.SHOW_IMPLICIT, 0);
    }

    protected void showKeyboard(){
        //get a system service called imm (input method manager)
        //LayoutInflaterService
        InputMethodManager imm = (InputMethodManager)
                getContext().getSystemService(Context.INPUT_METHOD_SERVICE);

        //0 == FORCE HIDE... Show params can be anything but 0.

        imm.toggleSoftInput(0, InputMethodManager.HIDE_IMPLICIT_ONLY);

//        EditText et = new EditText(getContext());
//        if (et.getWindowToken() != null)
//        imm.toggleSoftInputFromWindow(et.getWindowToken(), InputMethodManager.SHOW_IMPLICIT, 0);
    }

    protected FirebaseUser getUser(){
        return FirebaseAuth.getInstance().getCurrentUser();
    }
}

