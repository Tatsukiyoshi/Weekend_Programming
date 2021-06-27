package com.example.myslideshow

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_image.*

val IMG_RES_ID = "IMG_RES_ID"

/**
 * A simple [Fragment] subclass.
 */
class ImageFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_image, container, false)
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
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        imgResId?.let {
            imageView.setImageResource(it)
        }
    }
}
