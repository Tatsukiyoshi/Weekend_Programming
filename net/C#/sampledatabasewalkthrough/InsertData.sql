-- 結果表示しない
SET NOCOUNT ON 
-- １件ずつ日時を変えながら160000件追加するスクリプト
        DECLARE @CustomerID INT
        DECLARE @KhDtm Char(19)
        DECLARE @Dtm DATETIME

        -- 初期値設定
        SET @CustomerID = 1
        SET @Dtm = CONVERT(DATETIME, '2020/11/29 14:00:00')

        WHILE @CustomerID <= 10
        BEGIN
                -- 日付を文字列に変換する  
                SET @KhDtm = FORMAT(@Dtm, 'yyyy/MM/dd HH:mm:ss')
                INSERT INTO Customers (CustomerID,
                                    CompanyName,
                                    ContactName,
                                    ContactDate,
                                    Phone)
                VALUES
                        (@CustomerID, 
                        N'ABCカンパニー',
                        N'河野太郎',
                        @KhDtm,
                        '03-1234-5678')
                SET @CustomerID = @CustomerID + 1
                -- １秒ずつ進める
                SET @Dtm = DATEADD(SECOND, 1, @Dtm)
        END
