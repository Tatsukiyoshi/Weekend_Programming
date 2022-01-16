namespace Sample11
{
    partial class Form1
    {
        /// <summary>
        ///  Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

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
            this.lb = new System.Windows.Forms.Label();
            this.rt = new System.Windows.Forms.RichTextBox();
            this.tb = new System.Windows.Forms.TextBox();
            this.bt = new System.Windows.Forms.Button();
            this.tableLayoutPanel1 = new System.Windows.Forms.TableLayoutPanel();
            this.tableLayoutPanel1.SuspendLayout();
            this.SuspendLayout();
            // 
            // lb
            // 
            this.lb.AutoSize = true;
            this.lb.Dock = System.Windows.Forms.DockStyle.Fill;
            this.lb.Location = new System.Drawing.Point(21, 0);
            this.lb.Name = "lb";
            this.lb.Size = new System.Drawing.Size(260, 14);
            this.lb.TabIndex = 0;
            this.lb.Text = "入力してください。";
            // 
            // rt
            // 
            this.rt.Dock = System.Windows.Forms.DockStyle.Fill;
            this.rt.Location = new System.Drawing.Point(21, 17);
            this.rt.Name = "rt";
            this.rt.Size = new System.Drawing.Size(260, 181);
            this.rt.TabIndex = 1;
            this.rt.Text = "";
            // 
            // tb
            // 
            this.tb.Dock = System.Windows.Forms.DockStyle.Fill;
            this.tb.Location = new System.Drawing.Point(21, 204);
            this.tb.Name = "tb";
            this.tb.Size = new System.Drawing.Size(260, 23);
            this.tb.TabIndex = 2;
            // 
            // bt
            // 
            this.bt.Dock = System.Windows.Forms.DockStyle.Fill;
            this.bt.Location = new System.Drawing.Point(21, 233);
            this.bt.Name = "bt";
            this.bt.Size = new System.Drawing.Size(260, 25);
            this.bt.TabIndex = 3;
            this.bt.Text = "検索";
            this.bt.UseVisualStyleBackColor = true;
            this.bt.Click += new System.EventHandler(this.bt_Click);
            // 
            // tableLayoutPanel1
            // 
            this.tableLayoutPanel1.ColumnCount = 2;
            this.tableLayoutPanel1.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Percent, 6.5F));
            this.tableLayoutPanel1.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Percent, 93.5F));
            this.tableLayoutPanel1.Controls.Add(this.bt, 1, 3);
            this.tableLayoutPanel1.Controls.Add(this.lb, 1, 0);
            this.tableLayoutPanel1.Controls.Add(this.tb, 1, 2);
            this.tableLayoutPanel1.Controls.Add(this.rt, 1, 1);
            this.tableLayoutPanel1.Dock = System.Windows.Forms.DockStyle.Fill;
            this.tableLayoutPanel1.Location = new System.Drawing.Point(0, 0);
            this.tableLayoutPanel1.Name = "tableLayoutPanel1";
            this.tableLayoutPanel1.RowCount = 4;
            this.tableLayoutPanel1.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Percent, 7.272727F));
            this.tableLayoutPanel1.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Percent, 92.72727F));
            this.tableLayoutPanel1.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Absolute, 29F));
            this.tableLayoutPanel1.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Absolute, 30F));
            this.tableLayoutPanel1.Size = new System.Drawing.Size(284, 261);
            this.tableLayoutPanel1.TabIndex = 4;
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(7F, 15F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(284, 261);
            this.Controls.Add(this.tableLayoutPanel1);
            this.Name = "Form1";
            this.Text = "サンプル";
            this.tableLayoutPanel1.ResumeLayout(false);
            this.tableLayoutPanel1.PerformLayout();
            this.ResumeLayout(false);

        }

        #endregion

        private Label lb;
        private RichTextBox rt;
        private TextBox tb;
        private Button bt;
        private TableLayoutPanel tableLayoutPanel1;
    }
}