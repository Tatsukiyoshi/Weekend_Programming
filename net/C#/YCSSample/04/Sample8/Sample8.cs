using System.Windows.Forms;

class Sample8
{
    public static void Main()
    {
        Form fm = new Form();
        fm.Text = "サンプル";
        fm.Width = 250; fm.Height = 150;

        // ２次元配列
        string[,] str = new string[4, 3]{
            {"東京",  "Tokyo",    "とうきょう"},
            {"名古屋","Nagoya",   "なごや" },
            {"大阪",  "Osaka",    "おおさか"},
            {"福岡",  "Fukuoka",  "ふくおか"}
        };

        Label lb = new Label();
        lb.Width = fm.Width; lb.Height = fm.Height;

        // テンポラリ
        string tmp = "";

        for(int i = 0; i < 4; i++)
        {
            tmp += "(";

            for(int j = 0; j < 3; j++)
            {
                tmp += str[i, j];
                tmp += ",";
            }

            tmp += ")\n";
        }

        lb.Text = tmp;
        lb.Parent = fm;

        Application.Run(fm);
    }
}
