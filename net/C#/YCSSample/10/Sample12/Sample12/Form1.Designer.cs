namespace Sample12
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
            this.lbx = new System.Windows.Forms.ListBox();
            this.bt = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // lbx
            // 
            this.lbx.Dock = System.Windows.Forms.DockStyle.Top;
            this.lbx.FormattingEnabled = true;
            this.lbx.ItemHeight = 15;
            this.lbx.Location = new System.Drawing.Point(0, 0);
            this.lbx.Name = "lbx";
            this.lbx.Size = new System.Drawing.Size(234, 139);
            this.lbx.TabIndex = 0;
            // 
            // bt
            // 
            this.bt.Dock = System.Windows.Forms.DockStyle.Bottom;
            this.bt.Location = new System.Drawing.Point(0, 138);
            this.bt.Name = "bt";
            this.bt.Size = new System.Drawing.Size(234, 23);
            this.bt.TabIndex = 1;
            this.bt.Text = "起動";
            this.bt.UseVisualStyleBackColor = true;
            this.bt.Click += new System.EventHandler(this.bt_Click);
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(7F, 15F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(234, 161);
            this.Controls.Add(this.bt);
            this.Controls.Add(this.lbx);
            this.Name = "Form1";
            this.Text = "サンプル";
            this.ResumeLayout(false);

        }

        #endregion

        private ListBox lbx;
        private Button bt;
    }
}