package elshan.mov.mychronometer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.view.View
import android.widget.ActionMenuView
import elshan.mov.mychronometer.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var tempTime:Long=0
        binding.btnStart.setOnClickListener(){
            binding.chronometer.base=SystemClock.elapsedRealtime()+tempTime
            binding.chronometer.start()
            binding.btnStart.visibility=View.GONE
            binding.btnPause.visibility=View.VISIBLE
            binding.imageView.setImageDrawable(getDrawable(R.drawable.pause))
        }
        binding.btnPause.setOnClickListener(){
            tempTime=binding.chronometer.base-SystemClock.elapsedRealtime()
            binding.chronometer.stop()
            binding.btnStart.visibility=View.VISIBLE
            binding.btnPause.visibility=View.GONE
            binding.imageView.setImageDrawable(getDrawable(R.drawable.start))
        }
        binding.btnReset.setOnClickListener(){
            binding.chronometer.base=SystemClock.elapsedRealtime()
            binding.chronometer.stop()
            tempTime=0
            binding.btnStart.visibility=View.VISIBLE
            binding.btnPause.visibility=View.GONE
            binding.imageView.setImageDrawable(getDrawable(R.drawable.start))
        }
    }
}