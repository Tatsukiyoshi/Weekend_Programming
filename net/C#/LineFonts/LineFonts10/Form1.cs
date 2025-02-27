using System.Drawing.Text;
using System.Runtime.InteropServices;

namespace LineFonts
{
    public partial class Form1 : Form
    {
        //Create your private font collection object.
        PrivateFontCollection pfc = new();

        public Form1()
        {
            InitializeComponent();

            InitCustomLabelFont();

            RegularLabel.Font = new Font(pfc.Families[0], RegularLabel.Font.Size, FontStyle.Regular);
            RegularLabel.Text = "標準フォント";

            BoldLabel.Font = new Font(pfc.Families[1], BoldLabel.Font.Size, FontStyle.Bold);
            BoldLabel.Text = "太字フォント";
        }

        public void InitCustomLabelFont()
        {
            int fontLength;
            byte[] fontData;
            System.IntPtr data;

            // LINE Font(Regular) 
            {
                // 1: Select your font from the resources.
                fontLength = Properties.Resources.LINESeedJP_TTF_Rg.Length;

                // 2: create a buffer to read in to
                fontData = Properties.Resources.LINESeedJP_TTF_Rg;

                // 3: create an unsafe memory block for the font data
                data = Marshal.AllocCoTaskMem(fontLength);

                // 4: copy the bytes to the unsafe memory block
                Marshal.Copy(fontData, 0, data, fontLength);

                // 5: pass the font to the font collection
                pfc.AddMemoryFont(data, fontLength);
            }

            // LINE Font(Bold)
            {
                fontLength = Properties.Resources.LINESeedJP_TTF_Bd.Length;
                fontData = Properties.Resources.LINESeedJP_TTF_Bd;
                data = Marshal.AllocCoTaskMem(fontLength);
                Marshal.Copy(fontData, 0, data, fontLength);
                pfc.AddMemoryFont(data, fontLength);
            }
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            // .NET Framework
            //string clrVersionBuildTime = System.Reflection.Assembly.GetExecutingAssembly().ImageRuntimeVersion;
            //dotnetVersionLabel.Text = clrVersionBuildTime;
            dotnetVersionText.Text = RuntimeInformation.FrameworkDescription;
        }
    }
}
