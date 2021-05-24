package com.example.vismahomework.ui.history

import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.vismahomework.R
import com.example.vismahomework.databinding.ItemWeatherBinding
import com.example.vismahomework.models.WeatherBase
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

class WeatherListAdapter :
    ListAdapter<WeatherBase, WeatherListAdapter.WeatherListViewHolder>(WeatherDC()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = WeatherListViewHolder(
        ItemWeatherBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: WeatherListViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    fun swapData(data: List<WeatherBase>) {
        submitList(data.toMutableList())
    }

    inner class WeatherListViewHolder(
        private val binding: ItemWeatherBinding,
    ) : RecyclerView.ViewHolder(binding.root), OnClickListener {

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {

            if (adapterPosition == RecyclerView.NO_POSITION) return
        }

        fun bind(item: WeatherBase) = with(itemView) {
            with(binding) {
                cityName.text = item.name
                description.text = item.weather[0].description.capitalize()
                weatherIcon.load(item.iconURL)
                val calendar = Calendar.getInstance()
                calendar.time = Date(item.dt * 1000)
                weekday.text =
                    SimpleDateFormat("EE", Locale.US).format(calendar.get(Calendar.DAY_OF_WEEK))
                        .toUpperCase()
                day.text = calendar.get(Calendar.DAY_OF_MONTH).toString()
                temp.text = item.main.temp.toInt().toString()
                changeColors(item.main.temp.toInt(), binding, itemView)

            }
        }

        private fun changeColors(temp: Int, binding: ItemWeatherBinding, itemView: View) {
            with(binding) {
                when (temp) {
                    in Int.MIN_VALUE..10 -> {
                        cityName.setTextColor(ContextCompat.getColor(itemView.context,
                            R.color.yellow))
                        binding.temp.setTextColor(ContextCompat.getColor(itemView.context,
                            R.color.green))
                        degree.setTextColor(ContextCompat.getColor(itemView.context,
                            R.color.green))
                        day.setTextColor(ContextCompat.getColor(itemView.context,
                            R.color.red))
                        weekday.setTextColor(ContextCompat.getColor(itemView.context,
                            R.color.red))
                    }
                    in 10..19 -> {
                        cityName.setTextColor(ContextCompat.getColor(itemView.context,
                            R.color.red))
                        binding.temp.setTextColor(ContextCompat.getColor(itemView.context,
                            R.color.yellow))
                        degree.setTextColor(ContextCompat.getColor(itemView.context,
                            R.color.yellow))
                        day.setTextColor(ContextCompat.getColor(itemView.context,
                            R.color.green))
                        weekday.setTextColor(ContextCompat.getColor(itemView.context,
                            R.color.green))
                    }
                    in 20..Int.MAX_VALUE -> {
                        cityName.setTextColor(ContextCompat.getColor(itemView.context,
                            R.color.green))
                        binding.temp.setTextColor(ContextCompat.getColor(itemView.context,
                            R.color.red))
                        degree.setTextColor(ContextCompat.getColor(itemView.context,
                            R.color.red))
                        day.setTextColor(ContextCompat.getColor(itemView.context,
                            R.color.yellow))
                        weekday.setTextColor(ContextCompat.getColor(itemView.context,
                            R.color.yellow))
                    }
                }
            }
        }
    }

    private class WeatherDC : DiffUtil.ItemCallback<WeatherBase>() {
        override fun areItemsTheSame(
            oldItem: WeatherBase,
            newItem: WeatherBase,
        ) = oldItem.id1 == newItem.id1

        override fun areContentsTheSame(
            oldItem: WeatherBase,
            newItem: WeatherBase,
        ) = oldItem == newItem
    }
}
