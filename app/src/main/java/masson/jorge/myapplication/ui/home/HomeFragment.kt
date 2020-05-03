package masson.jorge.myapplication.ui.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.fragment_home.view.*
import masson.jorge.myapplication.R

class HomeFragment : Fragment() {

    var adapter: AdaptadorHome? = null
    var arrayList = ArrayList<Actividades>()
    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProviders.of(this).get(HomeViewModel::class.java)

        cargarActividades()

        val root = inflater.inflate(R.layout.fragment_home, container, false)

        adapter = AdaptadorHome(root.context, arrayList)

        root.gridview.adapter = adapter

        return root
    }

    fun cargarActividades() {
        arrayList.add(Actividades("Practice", "Everyday", "17:00"))
        arrayList.add(Actividades("Practice", "Everyday", "17:00"))
        arrayList.add(Actividades("Practice", "Everyday", "17:00"))
        arrayList.add(Actividades("Practice", "Everyday", "17:00"))
        arrayList.add(Actividades("Practice", "Everyday", "17:00"))
        arrayList.add(Actividades("Practice", "Everyday", "17:00"))
        arrayList.add(Actividades("Practice", "Everyday", "17:00"))
        arrayList.add(Actividades("Practice", "Everyday", "17:00"))
        arrayList.add(Actividades("Practice", "Everyday", "17:00"))
    }

    class AdaptadorHome: BaseAdapter {

        var arrayList = ArrayList<Actividades>()
        var context: Context? = null

        constructor(context: Context, arrayList: ArrayList<Actividades>) {
            this.context = context
            this.arrayList = arrayList
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            var actividad = arrayList[position]
            var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as  LayoutInflater
            var vista = inflator.inflate(R.layout.activity_view, null)

            return vista
        }

        override fun getItem(position: Int): Any {
            return arrayList[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getCount(): Int {
            return arrayList.size
        }

    }

}