package com.example.myslideshow

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myslideshow.databinding.FragmentImageBinding

const val IMG_RES_ID = "IMG_RES_ID"

/**
 * A simple [Fragment] subclass.
 */
class ImageFragment : Fragment() {
    private var _binding: FragmentImageBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentImageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    // コンパニオンオブジェクト
    companion object {
        // スタティックメソッド定義
        fun newInstance(imageResourceId: Int) : ImageFragment {
            val bundle = Bundle()
            bundle.putInt(IMG_RES_ID, imageResourceId)
            val imageFragment = ImageFragment()
            imageFragment.arguments = bundle
            return imageFragment
        }
    }

    // アーギュメンツから取り出した画像のリソースID
    private var imgResId: Int? = null

    // 作成時だけでなく、再作成時にも呼ばれる
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // argumentsプロパティで取り出す（安全呼び出し演算子、スコープ関数let）
        arguments?.let {
            imgResId = it.getInt(IMG_RES_ID)
        }
    }

    // フラグメント作成後
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        imgResId?.let {
            binding.imageView.setImageResource(it)
        }
    }
}
