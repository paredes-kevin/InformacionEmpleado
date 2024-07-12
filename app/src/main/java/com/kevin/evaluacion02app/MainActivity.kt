package com.kevin.evaluacion02app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.kevin.evaluacion02app.Model.Empleado
import com.kevin.evaluacion02app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var empleados: MutableList<Empleado>
    private lateinit var adaptador: AdapterEmpleados

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        empleados = getListaEmpleados()
        adaptador = AdapterEmpleados()

        binding.rvEmpleados.layoutManager = LinearLayoutManager(this)
        binding.rvEmpleados.adapter = adaptador
        adaptador.AdapterPaises(empleados, this)

        binding.btnPorApellido.setOnClickListener {
            ordenarPorApellido()
        }

        binding.btnPorPuesto.setOnClickListener {
            ordenarPorPuesto()
        }
    }

    private fun getListaEmpleados(): MutableList<Empleado> {
        val lista = mutableListOf<Empleado>()
        lista.add(Empleado("Ana", "García", "12345678A", "Asistente de Recursos Humanos", R.drawable.asistente))
        lista.add(Empleado("Javier", "Martínez", "23456789B", "Programador Senior", R.drawable.desarrollador))
        lista.add(Empleado("María", "Rodríguez", "34567890C", "Secretaria Ejecutiva", R.drawable.secretaria))
        lista.add(Empleado("Carlos", "Sánchez", "45678901D", "Analista Financiero", R.drawable.analista))
        lista.add(Empleado("Laura", "Pérez", "56789012E", "Gerente de Marketing", R.drawable.gerentem))
        lista.add(Empleado("Juan", "González", "67890123F", "Operario de Producción", R.drawable.operariop))
        lista.add(Empleado("Marta", "López", "78901234G", "Asistente Administrativo", R.drawable.asistenteadm))
        lista.add(Empleado("Sergio", "Torres", "89012345H", "Programador Web", R.drawable.programadorweb))
        lista.add(Empleado("Elena", "Ruiz", "90123456I", "Secretaria de Dirección", R.drawable.secretariadireccion))
        lista.add(Empleado("Pedro", "García", "01234567J", "Analista de Sistemas", R.drawable.analistasistema))
        lista.add(Empleado("Isabel", "Martín", "12345678K", "Gerente de Ventas", R.drawable.gerenteventas))
        lista.add(Empleado("Luis", "Gómez", "23456789L", "Operario de Mantenimiento", R.drawable.operariomantenimiento))
        lista.add(Empleado("Julia", "Fernández", "34567890M", "Asistente de Contabilidad", R.drawable.asistentecontabilidad))
        lista.add(Empleado("Alberto", "Pérez", "45678901N", "Programador de Aplicaciones Móviles", R.drawable.programadorappmoviles))
        lista.add(Empleado("Carmen", "Sánchez", "56789012O", "Secretaria Administrativa", R.drawable.secretariaadministrativa))
        lista.add(Empleado("Andrés", "López", "67890123P", "Analista de Datos", R.drawable.analistadedatos))
        lista.add(Empleado("Rosa", "Ramírez", "78901234Q", "Gerente de Operaciones", R.drawable.gerenteoperaciones))
        lista.add(Empleado("Diego", "Castro", "89012345R", "Operario de Almacén", R.drawable.operariodealmacen))
        lista.add(Empleado("Silvia", "Jiménez", "90123456S", "Asistente Comercial", R.drawable.asistentecomercial))
        lista.add(Empleado("Mario", "Martínez", "01234567T", "Programador de Base de Datos", R.drawable.programadorbasedatos))
        return lista
    }

    private fun ordenarPorApellido() {
        empleados.sortBy { it.Apellidos }
        adaptador.notifyDataSetChanged()
    }

    private fun ordenarPorPuesto() {
        empleados.sortBy { it.Puesto }
        adaptador.notifyDataSetChanged()
    }
}