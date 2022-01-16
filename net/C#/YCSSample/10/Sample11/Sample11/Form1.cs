using System.Text.RegularExpressions;

namespace Sample11
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void bt_Click(object sender, EventArgs e)
        {
            Regex rx = new Regex(tb.Text);
            Match? m = null;    // null許容型

            // 対象文字列について、検索を行い、検索が成功する間
            for(m = rx.Match(rt.Text);
                m.Success; m = m.NextMatch())
            {
                rt.Select(m.Index, m.Length);   // 範囲を選択
                rt.SelectionColor = Color.Red;  // 赤色にする
            }
        }
    }
}