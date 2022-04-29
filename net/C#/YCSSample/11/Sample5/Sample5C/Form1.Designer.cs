namespace Sample5C
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
            this.tb1 = new System.Windows.Forms.TextBox();
            this.tb2 = new System.Windows.Forms.TextBox();
            this.bt = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // tb1
            // 
            this.tb1.Dock = System.Windows.Forms.DockStyle.Top;
            this.tb1.Location = new System.Drawing.Point(0, 0);
            this.tb1.Name = "tb1";
            this.tb1.Size = new System.Drawing.Size(278, 31);
            this.tb1.TabIndex = 0;
            // 
            // tb2
            // 
            this.tb2.Dock = System.Windows.Forms.DockStyle.Top;
            this.tb2.Location = new System.Drawing.Point(0, 31);
            this.tb2.Multiline = true;
            this.tb2.Name = "tb2";
            this.tb2.ScrollBars = System.Windows.Forms.ScrollBars.Vertical;
            this.tb2.Size = new System.Drawing.Size(278, 150);
            this.tb2.TabIndex = 1;
            // 
            // bt
            // 
            this.bt.Dock = System.Windows.Forms.DockStyle.Bottom;
            this.bt.Location = new System.Drawing.Point(0, 210);
            this.bt.Name = "bt";
            this.bt.Size = new System.Drawing.Size(278, 34);
            this.bt.TabIndex = 2;
            this.bt.Text = "送信";
            this.bt.UseVisualStyleBackColor = true;
            this.bt.Click += new System.EventHandler(this.Bt_Click);
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(10F, 25F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(278, 244);
            this.Controls.Add(this.bt);
            this.Controls.Add(this.tb2);
            this.Controls.Add(this.tb1);
            this.Name = "Form1";
            this.Text = "サンプル";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private TextBox tb1;
        private TextBox tb2;
        private Button bt;
    }
}