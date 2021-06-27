CREATE TABLE [dbo].[Customers] (
    [CustomerID]  INT           NOT NULL,
    [CompanyName] NVARCHAR (50) NOT NULL,
    [ContactName] NVARCHAR (50) NULL,
    [ContactDate] NCHAR (19)    NULL,
    [Phone]       NVARCHAR (24) NULL,
    PRIMARY KEY CLUSTERED ([CustomerID] ASC)
);

