package com.kevin.evaluacion02app

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kevin.evaluacion02app.Model.Empleado

class AdapterEmpleados: RecyclerView.Adapter<AdapterEmpleados.ViewHolder>() {
    var empleados: MutableList<Empleado> = ArrayList()
    lateinit var context: Context
    fun AdapterPaises(listaEmpleados: MutableList<Empleado>, context: Context) {
        this.empleados = listaEmpleados
        this.context = context
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterEmpleados.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.
        inflate(R.layout.item_empleados_layout, parent, false))
    }
    override fun getItemCount(): Int { return empleados.size
    }
    override fun onBindViewHolder(holder: AdapterEmpleados.ViewHolder, position: Int) {
        val item = empleados.get(position)
        holder.bind(item, context)
    }
    class ViewHolder(vista: View):RecyclerView.ViewHolder(vista) {
        val nombre = vista.findViewById<TextView>(R.id.tvNombre)
        val apellido = vista.findViewById<TextView>(R.id.tvApellido)
        val dni = vista.findViewById<TextView>(R.id.tvDNI)
        val puesto = vista.findViewById<TextView>(R.id.tvPuesto)
        val foto = vista.findViewById<ImageView>(R.id.ivFoto)
        fun bind (empleado: Empleado, context: Context) {
            nombre.setText(empleado.Nombre)
            apellido.setText(empleado.Apellidos)
            dni.setText(empleado.DNI)
            puesto.setText(empleado.Puesto)
            foto.setImageResource(empleado.Fotografia)
        }
    }
}