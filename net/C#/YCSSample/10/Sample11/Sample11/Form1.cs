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
            Match? m = null;    // null���e�^

            // �Ώە�����ɂ��āA�������s���A���������������
            for(m = rx.Match(rt.Text);
                m.Success; m = m.NextMatch())
            {
                rt.Select(m.Index, m.Length);   // �͈͂�I��
                rt.SelectionColor = Color.Red;  // �ԐF�ɂ���
            }
        }
    }
}