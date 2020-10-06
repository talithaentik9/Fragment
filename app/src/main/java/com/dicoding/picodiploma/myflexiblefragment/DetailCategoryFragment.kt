package com.dicoding.picodiploma.myflexiblefragment

import android.accounts.AuthenticatorDescription
import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.security.identity.AccessControlProfile
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_detail_category.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [DetailCategoryFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DetailCategoryFragment : Fragment() {

    lateinit var  tvCategoryName: TextView
    lateinit var tvCategoryDescription: TextView
    lateinit var btnProfile: Button
    lateinit var  btnShowDialog: Button

    var description: String? = null

    companion object {
        var EXTRA_NAME = "extra_name"
        var EXTRA_DESCRIPTION = "extra_description"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_category, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tvCategoryName = view.findViewById(R.id.tv_category_name)
        tvCategoryDescription = view.findViewById(R.id.tv_category_description)
        btnProfile = view.findViewById(R.id.btn_profile)
        btnProfile.setOnClickListener(this)
        btnShowDialog = view.findViewById(R.id.btn_show_dialog)
        btnShowDialog.setOnClickListener(this)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        if (savedInstanceState != null) {
            val descfromBundle = savedInstanceState.getString(EXTRA_DESCRIPTION)
            description = descfromBundle
        }
        if (arguments != null) {
            val  categoryName = arguments?.getString(EXTRA_NAME)
            tv_category_name.text = description
            tv_category_description.text = description
        }
    }
    override fun  onClick(v: View) {
        when (v.id) {
          R.id.btn_profile -> {
              val mIntent = Intent(Activity, ProfileActivity::class.java)
              startActivity(mIntent)
          }

          R.id.btn_show_dialog -> {
              val mOptionalDialogFragment = OptionalDialogFragment()

              val mFragmentManager = childFragmentManager()
              mOptionalDialogFragment.show(mFragmentManager,OptionalDialogFragment::class.java.simpleName)
          }
        }
    }
    internal var optionDialogListener : OptionalDialogFragment.OptionalDialogListener = object : OptionDialogFragment.OptionDialogListener {
        override fun onOptionChosen(text: String?) {
            Toast.makeText(activity,text,Toast.LENGTH_SHORT).show()
        }
    }

}