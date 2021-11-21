using Timer = System.Windows.Forms.Timer;

namespace Sample2
{
    public partial class Form1 : Form
    {
        private int t;  // �o�ߎ���

        public Form1()
        {
            InitializeComponent();

            this.DoubleBuffered = true;
            t = 0;

            Timer tm = new Timer();
            tm.Interval = 100;
            tm.Start();

            this.Paint += new PaintEventHandler(Fm_Paint);
            tm.Tick += new EventHandler(Tm_Tick);
        }

        private void Tm_Tick(object? sender, EventArgs e)
        {
            t++;
            if (t > 600) t = 0; // 1���o�߂ōŏ��ɖ߂�܂�

            this.Invalidate();
        }

        private void Fm_Paint(object? sender, PaintEventArgs e)
        {
            Graphics g = e.Graphics;

            int w = this.ClientSize.Width;
            int h = this.ClientSize.Height;

            // ���o�ߎ��Ԃ�ȉ~�ŕ`�悵�܂�
            g.FillEllipse(new SolidBrush(Color.DeepPink), 0, 0, w, h);

            // �o�ߎ��ԕ����~�ʂŕ`�悵�܂�
            g.FillPie(new SolidBrush(Color.DarkOrchid), 0, 0, w, h, -90, (float)0.6 * t);

            // ���S������ȉ~�ŕ`�悵�܂�
            g.FillEllipse(new SolidBrush(Color.Bisque), (int)(w / 4), (int)(h / 4), (int)(w / 2), (int)(h / 2));

            // �o�ߎ��Ԃ�\��������
            string time = t / 10 + ":" + "0" + t % 10;

            // �w��t�H���g�ŕ\�������ꍇ�̃T�C�Y�𒲂ׂ܂�
            Font f = new("Courier", 20);
            SizeF ts = g.MeasureString(time, f);

            // �����𒲂ׂ܂�
            float tx = (w - ts.Width) / 2;
            float ty = (h - ts.Height) / 2;

            g.DrawString(time, f, new SolidBrush(Color.Black), tx, ty);
        }
    }
}