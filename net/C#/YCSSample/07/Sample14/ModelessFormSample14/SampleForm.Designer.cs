namespace ModelessFormSample14
{
    partial class SampleForm
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
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
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.lb = new System.Windows.Forms.Label();
            this.bt = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // lb
            // 
            this.lb.AutoSize = true;
            this.lb.Dock = System.Windows.Forms.DockStyle.Top;
            this.lb.Location = new System.Drawing.Point(0, 0);
            this.lb.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.lb.Name = "lb";
            this.lb.Size = new System.Drawing.Size(121, 15);
            this.lb.TabIndex = 0;
            this.lb.Text = "新しい店をはじめました。";
            // 
            // bt
            // 
            this.bt.Dock = System.Windows.Forms.DockStyle.Bottom;
            this.bt.Location = new System.Drawing.Point(0, 172);
            this.bt.Margin = new System.Windows.Forms.Padding(4);
            this.bt.Name = "bt";
            this.bt.Size = new System.Drawing.Size(273, 29);
            this.bt.TabIndex = 1;
            this.bt.Text = "OK";
            this.bt.UseVisualStyleBackColor = true;
            this.bt.Click += new System.EventHandler(this.bt_Click);
            // 
            // SampleForm
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(7F, 15F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(273, 201);
            this.Controls.Add(this.bt);
            this.Controls.Add(this.lb);
            this.Margin = new System.Windows.Forms.Padding(4);
            this.Name = "SampleForm";
            this.Text = "新規";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label lb;
        private System.Windows.Forms.Button bt;
    }
}