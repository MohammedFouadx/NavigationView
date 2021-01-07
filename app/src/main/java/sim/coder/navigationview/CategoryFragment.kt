package sim.coder.navigationview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.TextView


class CategoryFragment : Fragment() {


    var s:String=""
    lateinit var categoryText :TextView
    lateinit var frameLayout: FrameLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.app_bar_main, container, false)
        s=arguments?.getSerializable("data") as String
        categoryText= view.findViewById(R.id.category_text)
        frameLayout=view.findViewById(R.id.frame_container)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        when (s){
            "Book" -> {
                categoryText.text="Book Fragment"
                frameLayout.setBackgroundResource(R.color.design_default_color_primary)
                //Toast.makeText(context,"Book Fragment", Toast.LENGTH_LONG).show()
            }
            "Novels" ->{
                categoryText.text="Novels Fragment"
                frameLayout.setBackgroundResource(R.color.design_default_color_error)
            }

        }
    }

    companion object {

        @JvmStatic
        fun newInstance(data: String): CategoryFragment {
            val args = Bundle().apply {
                putSerializable("data", data)
            }
            return CategoryFragment().apply {
                arguments = args
            }
        }
    }
}