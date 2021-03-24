package com.eduardogeiselperes.roomdatabase.fragments.update

import android.app.AlertDialog
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.eduardogeiselperes.roomdatabase.R
import com.eduardogeiselperes.roomdatabase.model.Vehicle
import com.eduardogeiselperes.roomdatabase.viewmodel.VehicleViewModel
import kotlinx.android.synthetic.main.fragment_update.*
import kotlinx.android.synthetic.main.fragment_update.view.*


class UpdateFragment : Fragment() {

    private val args by navArgs<UpdateFragmentArgs>()

    private lateinit var vehicleViewMoel: VehicleViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_update, container, false)

        vehicleViewMoel = ViewModelProvider(this).get(VehicleViewModel::class.java)

        view.et_makeUpdate.setText(args.currentVehicle.make)
        view.et_modelUpdate.setText(args.currentVehicle.model)
        view.et_yearUpdate.setText(args.currentVehicle.year.toString())

        view.btn_update.setOnClickListener {
            updateItem()
        }

        // Add menu
        setHasOptionsMenu(true)

        return view
    }

    private fun updateItem(){
        val make = et_makeUpdate.text.toString()
        val model = et_modelUpdate.text.toString()
        val year = Integer.parseInt(et_yearUpdate.text.toString())

        if(inputCheck(make, model, et_yearUpdate.text)){
            // Create Vehicle Object
            val updatedVehicle = Vehicle(args.currentVehicle.id, make, model, year)
            // Update Current Vehicle
            vehicleViewMoel.updateVehicle(updatedVehicle)
            Toast.makeText(requireContext(), "Updated Successfully!", Toast.LENGTH_SHORT).show()
            // Navigate Back
            findNavController().navigate(R.id.action_updateFragment_to_listFragment)
        }else{
            Toast.makeText(requireContext(), "Please fill out all fields.", Toast.LENGTH_SHORT).show()
        }
    }

    private fun inputCheck(firstName: String, lastName: String, age: Editable): Boolean{
        return !(TextUtils.isEmpty(firstName) && TextUtils.isEmpty(lastName) && age.isEmpty())
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.delete_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menu_delete) {
            deleteVehicle()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun deleteVehicle() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setPositiveButton("Yes") { _, _ ->
            vehicleViewMoel.deleteVehicle(args.currentVehicle)
            Toast.makeText(
                requireContext(),
                "Successfully removed: ${args.currentVehicle.model}",
                Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_updateFragment_to_listFragment)
        }
        builder.setNegativeButton("No") { _, _ -> }
        builder.setTitle("Delete ${args.currentVehicle.model}?")
        builder.setMessage("Are you sure you want to delete ${args.currentVehicle.model}?")
        builder.create().show()
    }

}