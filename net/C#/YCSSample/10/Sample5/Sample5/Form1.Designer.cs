namespace Sample5
{
    partial class Form1
    {
        /// <summary>
        ///  Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        private TextBox tb;
        private ToolStrip ts;
        private ToolStripButton[] tsb = new ToolStripButton[3];
        private Button bt1, bt2;
        private FlowLayoutPanel flp;

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
            this.ClientSize = new System.Drawing.Size(800, 450);
            this.Text = "サンプル";

            // ツールバーの作成
            ts = new ToolStrip();

            // ツールバーのボタン作成
            for(int i = 0; i < tsb.Length; i++)
            {
                tsb[i] = new ToolStripButton();
            }

            // ツールバーのボタンへのイメージ割付
            tsb[0].Image = Sample5.cut;
            tsb[1].Image = Sample5.copy;
            tsb[2].Image = Sample5.paste;

            // ボタンへカーソルをあてた時のテキスト
            tsb[0].ToolTipText = "カット";
            tsb[1].ToolTipText = "コピー";
            tsb[2].ToolTipText = "ペースト";

            // テキストボックス
            tb = new TextBox();
            tb.Multiline = true; // テキストボックスを複数行表示にする
            tb.Width = this.Width;
            tb.Height = this.Height - 100;
            tb.Dock = DockStyle.Top;

            // コマンドボタン
            bt1 = new Button();
            bt2 = new Button();
            bt1.Text = "読込";
            bt2.Text = "保存";

            flp = new FlowLayoutPanel();
            flp.Dock = DockStyle.Bottom;

            for(int i = 0; i < tsb.Length; i++)
            {
                ts.Items.Add(tsb[i]);
            }

            bt1.Parent = flp;
            bt2.Parent = flp;
            flp.Parent = this;
            tb.Parent = this;
            ts.Parent = this;

            // イベントハンドラー設定
            bt1.Click += new EventHandler(bt1_Click);
            bt2.Click += new EventHandler(bt2_Click);

            for(int i = 0; i < tsb.Length; i++)
            {
                tsb[i].Click += new EventHandler(tsb_Click);
            }

        }

        private void bt1_Click(object sender, EventArgs e)
        {
            // テキストファイルの読み込み
            OpenFileDialog ofd = new OpenFileDialog();
            ofd.Filter = "テキストファイル|*.txt";

            if(ofd.ShowDialog() == DialogResult.OK)
            {
                StreamReader sr = new StreamReader(ofd.FileName,
                    System.Text.Encoding.Default);
                tb.Text = sr.ReadToEnd();
                sr.Close();
            }
        }

        private void bt2_Click(object sender, EventArgs e)
        {
            // テキストファイルの保存
            SaveFileDialog sfd = new SaveFileDialog();
            sfd.Filter = "テキストファイル|*.txt";

            if (sfd.ShowDialog() == DialogResult.OK)
            {
                StreamWriter sw = new StreamWriter(sfd.FileName);
                sw.WriteLine(tb.Text);
                sw.Close();
            }
        }

        private void tsb_Click(object sender, EventArgs e)
        {
            if(sender == tsb[0])
            {
                tb.Cut();
            } 
            else if(sender == tsb[1])
            {
                tb.Copy();
            } 
            else if(sender == tsb[2])
            {
                tb.Paste();
            }
        }

        #endregion
    }
}