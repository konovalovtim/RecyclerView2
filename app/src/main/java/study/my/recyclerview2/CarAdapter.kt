package study.my.recyclerview2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CarAdapter(private val cars: List<Car>, private val onCarClickListener: CarClickListener) : RecyclerView.Adapter<CarAdapter.CarViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.car_item, parent, false)

        view.setOnClickListener { v: View -> onCarClickListener.onCarClick(v.tag as Car) }
        return CarViewHolder(view)
    }

    override fun onBindViewHolder(holder: CarViewHolder, position: Int) {
        val car = cars[position]
        holder.bind(car)
        holder.itemView.tag = car
    }

    override fun getItemCount(): Int {
        return cars.size
    }

    class CarViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val manufactureTextView: TextView = itemView.findViewById(R.id.manufacturer)
        private val modelTextView: TextView = itemView.findViewById(R.id.model)


        fun bind(car: Car) {
            manufactureTextView.text = car.manufacturer
            modelTextView.text = car.model
        }
    }

    interface CarClickListener {
        fun onCarClick(car: Car?)
    }
}