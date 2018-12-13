package startup.softflix.com.startup

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.animal_ticket.view.*

class MainActivity : AppCompatActivity() {


    var listOfAnimals= ArrayList<Animal>()
    var adapter: AnimalsAdapter?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //load animals
        listOfAnimals.add(
                Animal("Baboon","Baboon live in  big place with tree",R.drawable.baboon))
        listOfAnimals.add(
                Animal("Bulldog","Bulldog live in  big place with tree",R.drawable.bulldog))
        listOfAnimals.add(
                Animal("Panda","Panda live in  big place with tree",R.drawable.panda))
        listOfAnimals.add(
                Animal("Swallow","Swallow live in  big place with tree",R.drawable.swallow_bird))
        listOfAnimals.add(
                Animal("Tiger","Tiger live in  big place with tree",R.drawable.white_tiger))
        listOfAnimals.add(
                Animal("Zebra","Zebra live in  big place with tree",R.drawable.zebra))

        adapter = AnimalsAdapter(this,listOfAnimals)
        tvListAnimal.adapter= adapter
    }

    class AnimalsAdapter:BaseAdapter
    {
        var listOfAnimal= ArrayList<Animal>()

        var context:Context?=null
        constructor(context:Context, listOfAnimal: ArrayList<Animal>):super()
        {
            this.listOfAnimal=listOfAnimal
            this.context= context
        }
        //this method will run number of times = getcount return number(last method)
        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val animal =listOfAnimal[position]
            var inflator= context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var myView= inflator.inflate(R.layout.animal_ticket,null)
            myView.tvName.text=animal.name!!
            myView.tvDes.text= animal.des!!
            myView.ivAnimalImage.setImageResource(animal.image!!)
            return myView
        }

        override fun getItem(position: Int): Any {
            return listOfAnimal[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getCount(): Int {
             return listOfAnimal.size
        }

    }
}
