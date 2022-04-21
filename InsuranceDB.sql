USE [master]
GO
/****** Object:  Database [InsuranceDB]    Script Date: 4/20/2022 1:13:58 AM ******/
CREATE DATABASE [InsuranceDB]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'InsuranceDB', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\InsuranceDB.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'InsuranceDB_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\InsuranceDB_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [InsuranceDB] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [InsuranceDB].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [InsuranceDB] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [InsuranceDB] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [InsuranceDB] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [InsuranceDB] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [InsuranceDB] SET ARITHABORT OFF 
GO
ALTER DATABASE [InsuranceDB] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [InsuranceDB] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [InsuranceDB] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [InsuranceDB] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [InsuranceDB] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [InsuranceDB] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [InsuranceDB] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [InsuranceDB] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [InsuranceDB] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [InsuranceDB] SET  ENABLE_BROKER 
GO
ALTER DATABASE [InsuranceDB] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [InsuranceDB] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [InsuranceDB] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [InsuranceDB] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [InsuranceDB] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [InsuranceDB] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [InsuranceDB] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [InsuranceDB] SET RECOVERY FULL 
GO
ALTER DATABASE [InsuranceDB] SET  MULTI_USER 
GO
ALTER DATABASE [InsuranceDB] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [InsuranceDB] SET DB_CHAINING OFF 
GO
ALTER DATABASE [InsuranceDB] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [InsuranceDB] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [InsuranceDB] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [InsuranceDB] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
EXEC sys.sp_db_vardecimal_storage_format N'InsuranceDB', N'ON'
GO
ALTER DATABASE [InsuranceDB] SET QUERY_STORE = OFF
GO
USE [InsuranceDB]
GO
/****** Object:  Table [dbo].[Account]    Script Date: 4/20/2022 1:13:58 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Account](
	[id] [int] NOT NULL,
	[username] [nvarchar](50) NULL,
	[password] [nvarchar](50) NULL,
 CONSTRAINT [PK_Account] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[Account] ([id], [username], [password]) VALUES (1, N'admin', N'123')
INSERT [dbo].[Account] ([id], [username], [password]) VALUES (2, N'admin1', N'123')
INSERT [dbo].[Account] ([id], [username], [password]) VALUES (3, N'admin3', N'123')
INSERT [dbo].[Account] ([id], [username], [password]) VALUES (4, N'admin4', N'123')
GO
USE [master]
GO
ALTER DATABASE [InsuranceDB] SET  READ_WRITE 
GO
