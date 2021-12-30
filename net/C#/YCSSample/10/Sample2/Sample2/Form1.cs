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
            bt1.Text = "�Ǎ�";
            bt2.Text = "�ۑ�";

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

        private void bt2_click(object? sender, EventArgs e)     // �t�@�C����ۑ�����
        {
            SaveFileDialog sfd = new(); // new���ȑf��
            sfd.Filter = "�e�L�X�g�t�@�C��|*.txt";  // �t�@�C���t�B���^���g��

            if(sfd.ShowDialog() == DialogResult.OK)
            {
                StreamWriter sw = new(sfd.FileName);
                sw.WriteLine(tb.Text);
                sw.Close();
            }
        }

        private void bt1_click(object? sender, EventArgs e)     // �t�@�C����ǂݍ���
        {
            OpenFileDialog ofd = new(); // new���ȑf��
            ofd.Filter = "�e�L�X�g�t�@�C��|*.txt";

            if(ofd.ShowDialog() == DialogResult.OK)
            {
                // �X�g���[�����쐬����
                StreamReader sr = new(ofd.FileName, System.Text.Encoding.Default);

                // �����X�g���[������ǂݍ���
                tb.Text = sr.ReadToEnd();

                // �X�g���[�������
                sr.Close();
            }
        }
    }
}