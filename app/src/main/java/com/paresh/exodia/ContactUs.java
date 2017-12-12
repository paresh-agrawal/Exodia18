package com.paresh.exodia;


import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;


/**
 * A simple {@link Fragment} subclass.
 */
public class ContactUs extends Fragment {


    public ContactUs() {
        // Required empty public constructor
    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View contact_us = inflater.inflate(R.layout.fragment_contact_us, container, false);
        ((MainActivity) getActivity())
                .setActionBarTitle("Our Team");
        RelativeLayout ivcall = (RelativeLayout) contact_us.findViewById(R.id.iv_call_image_param);
        RelativeLayout ivcall1 = (RelativeLayout)contact_us.findViewById(R.id.iv_call_image_purvesh);
        RelativeLayout ivcall2 = (RelativeLayout)contact_us.findViewById(R.id.iv_call_image_prateek);
        RelativeLayout ivcall3 = (RelativeLayout)contact_us.findViewById(R.id.iv_call_image_navneet);
        RelativeLayout ivcall4 = (RelativeLayout)contact_us.findViewById(R.id.iv_call_image_anant);
        RelativeLayout ivcall5 = (RelativeLayout)contact_us.findViewById(R.id.iv_call_image_shivam);
        RelativeLayout ivcall6 = (RelativeLayout)contact_us.findViewById(R.id.iv_call_image_palak);
        RelativeLayout ivcall7 = (RelativeLayout)contact_us.findViewById(R.id.iv_call_image_parimal);
        RelativeLayout ivcall8 = (RelativeLayout)contact_us.findViewById(R.id.iv_call_image_hardeep);
        RelativeLayout ivcall9 = (RelativeLayout)contact_us.findViewById(R.id.iv_call_image_rohit);
        RelativeLayout ivcall10 = (RelativeLayout)contact_us.findViewById(R.id.iv_call_image_vishnu);
        RelativeLayout ivcall11 = (RelativeLayout)contact_us.findViewById(R.id.iv_call_image_shishir);
        RelativeLayout ivcall12 = (RelativeLayout)contact_us.findViewById(R.id.iv_call_image_rocky);
        RelativeLayout ivcall13 = (RelativeLayout)contact_us.findViewById(R.id.iv_call_image_gaurav);
        RelativeLayout ivcall14 = (RelativeLayout)contact_us.findViewById(R.id.iv_call_image_gagan);
        RelativeLayout ivcall15 = (RelativeLayout)contact_us.findViewById(R.id.iv_call_image_hritik);
        RelativeLayout ivcall16 = (RelativeLayout)contact_us.findViewById(R.id.iv_call_image_ashutosh);
        RelativeLayout ivcall17 = (RelativeLayout)contact_us.findViewById(R.id.iv_call_image_shubham);

        ivcall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse("tel:+919619071362")));
            }
        });
        ivcall1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse("tel:+918989773933")));
            }
        });
        ivcall2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse("tel:+918894924593")));
            }
        });
        ivcall3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse("tel:+919464895402")));
            }
        });
        ivcall4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse("tel:+919456456296")));
            }
        });
        ivcall5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse("tel:+917807112988")));
            }
        });
        ivcall6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse("tel:+917508002001")));
            }
        });
        ivcall7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse("tel:+918504977737")));
            }
        });
        ivcall8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse("tel:+919999559836")));
            }
        });
        ivcall9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse("tel:+919454537830")));
            }
        });
        ivcall10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse("tel:+917018590593")));
            }
        });
        ivcall11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse("tel:+919810580980")));
            }
        });
        ivcall12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse("tel:+919816729336")));
            }
        });
        ivcall13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse("tel:+918619343008")));
            }
        });
        ivcall14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse("tel:+917018343879")));
            }
        });
        ivcall15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse("tel:+918178412942")));
            }
        });
        ivcall16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse("tel:+917807104705")));
            }
        });
        ivcall17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse("tel:+918700817547")));
            }
        });

        return contact_us;
    }
    @Override
    public void onResume() {
        super.onResume();

        if(getView() == null){
            return;
        }

        getView().setFocusableInTouchMode(true);
        getView().requestFocus();
        getView().setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {

                if (event.getAction() == KeyEvent.ACTION_UP && keyCode == KeyEvent.KEYCODE_BACK){
                    Fragment fragment = new Home();
                    FragmentTransaction ft = getFragmentManager().beginTransaction();
                    ft.replace(R.id.content_frame,fragment);
                    ft.commit();
                    return true;
                }
                return false;
            }
        });
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
