using Timer = System.Windows.Forms.Timer;

namespace Item1
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

            int cw = this.ClientSize.Width;
            int ch = this.ClientSize.Height;
            int rh = ch - (int)(0.5 * t);

            // ���o�ߎ��Ԃ𒷕��`�ŕ`�悵�܂�
            g.FillRectangle(new SolidBrush(Color.DeepPink), 0, 0, cw, ch);

            // �o�ߎ��ԕ��𒷕��`�ŕ`�悵�܂�
            // g.FillRectangle(new SolidBrush(Color.DarkOrchid), 0, ch - rh, cw, rh); // ���������Ă�������
            g.FillRectangle(new SolidBrush(Color.DarkOrchid), 0, 0, cw, rh);

            // �o�ߎ��Ԃ�\��������
            string time = t / 10 + ":" + "0" + t % 10;

            // �w��t�H���g�ŕ\�������ꍇ�̃T�C�Y�𒲂ׂ܂�
            Font f = new("Courier", 20);
            SizeF ts = g.MeasureString(time, f);

            // �����𒲂ׂ܂�
            float tx = (cw - ts.Width) / 2;
            float ty = (ch - ts.Height) / 2;

            g.DrawString(time, f, new SolidBrush(Color.Black), tx, ty);
        }
    }
}