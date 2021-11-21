namespace sample1
{
    partial class Form1
    {
        /// <summary>
        ///  Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;
        private TableLayoutPanel tlp;
        private RadioButton[] rb = new RadioButton[4];
        private Image cim;
        private Image[] mim = new Image[4];
        private PictureBox pb;
        private Label lb;

        private int num;        // カードのマーク
        private bool isOpen;    // カードの表裏

        private Properties.Settings settings = new Properties.Settings();

        /// <summary>
        ///  Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        ///  Required method for Designer support - do not modify
        ///  the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.components = new System.ComponentModel.Container();
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(650, 450);
            this.Text = "サンプル";

            // TableLayoutPanel
            tlp = new TableLayoutPanel();
            tlp.Dock = DockStyle.Fill;
            tlp.ColumnCount = 4;
            tlp.RowCount = 2;

            // 4枚の絵札作成
            for(int i = 0; i < rb.Length; i++)
            {
                mim[i] = Image.FromFile(settings.strImagePath + "mark" + i + ".bmp");
                rb[i] = new RadioButton();
                rb[i].Image = mim[i];
                rb[i].AutoSize = true;
                rb[i].Parent = tlp;
            }

            // ランダムに決まる絵札
            cim = Image.FromFile(settings.strImagePath + "card.bmp");
            pb = new PictureBox();
            pb.Image = cim;
            pb.SizeMode = PictureBoxSizeMode.AutoSize;
            pb.Anchor = AnchorStyles.None;
            pb.Parent = tlp;

            // 結果表示用ラベル
            lb = new Label();
            lb.Font = new Font("SansSerif", 50, FontStyle.Bold);
            lb.AutoSize = true;
            lb.Anchor = AnchorStyles.None;
            lb.Parent = tlp;

            tlp.SetColumnSpan(pb, 2);
            tlp.SetColumnSpan(lb, 2);

            tlp.Parent = this;

            isOpen = false;
            Random rn = new Random();
            num = rn.Next(4);

            pb.Click += new EventHandler(pb_Click);
        }

        private void pb_Click(object sender, EventArgs e)
        {
            if(isOpen == false)
            {
                isOpen = true;
                pb.Image = mim[num];

                if(rb[num].Checked == true)
                {
                    lb.ForeColor = Color.DeepPink;
                    lb.Text = "Hit!";
                } else
                {
                    lb.ForeColor = Color.SlateBlue;
                    lb.Text = "Miss!";
                }
            } else
            {
                isOpen = false;
                lb.Text = "";
                pb.Image = cim;

                Random rn = new Random();
                num = rn.Next(4);
            }
        }

        #endregion
    }
}