namespace Sample2
{
    public partial class Form1 : Form
    {
        private TextBox tb;
        private Button bt1, bt2;
        private FlowLayoutPanel flp;

        public Form1()
        {
            InitializeComponent();

            tb = new TextBox();
            tb.Multiline = true;
            tb.Width = this.Width;
            tb.Height = this.Height - 100;
            tb.Dock = DockStyle.Top;

            bt1 = new Button();
            bt2 = new Button();
            bt1.Text = "読込";
            bt2.Text = "保存";

            flp = new FlowLayoutPanel();
            flp.Dock = DockStyle.Bottom;

            bt1.Parent = flp;
            bt2.Parent = flp;
            flp.Parent = this;
            tb.Parent = this;

            bt1.Click += new EventHandler(bt1_click);
            bt2.Click += new EventHandler(bt2_click);

            this.MaximizeBox = false;
        }

        private void bt2_click(object? sender, EventArgs e)     // ファイルを保存する
        {
            SaveFileDialog sfd = new(); // newを簡素化
            sfd.Filter = "テキストファイル|*.txt";  // ファイルフィルタを使う

            if(sfd.ShowDialog() == DialogResult.OK)
            {
                StreamWriter sw = new(sfd.FileName);
                sw.WriteLine(tb.Text);
                sw.Close();
            }
        }

        private void bt1_click(object? sender, EventArgs e)     // ファイルを読み込む
        {
            OpenFileDialog ofd = new(); // newを簡素化
            ofd.Filter = "テキストファイル|*.txt";

            if(ofd.ShowDialog() == DialogResult.OK)
            {
                // ストリームを作成する
                StreamReader sr = new(ofd.FileName, System.Text.Encoding.Default);

                // 文字ストリームから読み込む
                tb.Text = sr.ReadToEnd();

                // ストリームを閉じる
                sr.Close();
            }
        }
    }
}