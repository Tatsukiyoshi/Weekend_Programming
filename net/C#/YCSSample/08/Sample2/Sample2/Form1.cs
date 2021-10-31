namespace Sample2
{
    public partial class Form1 : Form
    {
        private const string strImagePath = "..\\..\\..\\..\\..\\..\\data\\";
        private Image im;
        private RadioButton rb1, rb2, rb3;
        private GroupBox gb;
        private int i;

        public Form1()
        {
            InitializeComponent();

            im = Image.FromFile(strImagePath + "car.bmp");

            gb = new GroupBox();
            gb.Text = "éÌóﬁ";
            gb.Dock = DockStyle.Bottom;
            gb.Parent = this;

            // ägëÂÅEèkè¨ÇÃëIëÉ{É^Éì
            rb1 = new RadioButton();
            rb1.Text = "í èÌ";
            rb1.Dock = DockStyle.Bottom;
            rb1.Checked = true;
            rb1.Parent = gb;
            rb1.Click += new EventHandler(rb_Click);

            rb2 = new RadioButton();
            rb2.Text = "ägëÂ";
            rb2.Dock = DockStyle.Bottom;
            rb2.Parent = gb;
            rb2.Click += new EventHandler(rb_Click);

            rb3 = new RadioButton();
            rb3.Text = "èkè¨";
            rb3.Dock = DockStyle.Bottom;
            rb3.Parent = gb;
            rb3.Click += new EventHandler(rb_Click);

            this.Paint += new PaintEventHandler(fm_Paint);
        }

        public void rb_Click(Object sender, EventArgs e)
        {
            RadioButton clickButton = (RadioButton)sender;

            if(clickButton == rb1) i = 1;
            else if(clickButton == rb2) i = 2;
            else if(clickButton == rb3) i = 3;
            this.Invalidate();
        }

        public void fm_Paint(Object sender, PaintEventArgs e)
        {
            Graphics g = e.Graphics;

            if (i == 1) g.DrawImage(im, 0, 0);
            else if (i == 2) g.DrawImage(im, 0, 0, im.Width * 2, im.Height * 2);
            else if (i == 3) g.DrawImage(im, 0, 0, im.Width / 2, im.Height / 2);
        }
    }
}