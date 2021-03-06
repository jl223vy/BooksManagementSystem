USE [master];
GO
IF DB_ID('BMSBase') IS NOT NULL
	BEGIN
		ALTER DATABASE BMSBase
			SET SINGLE_USER
			WITH ROLLBACK IMMEDIATE;
		DROP DATABASE BMSBase;
	END
/****** Object:  Database [BMSBase]    Script Date: 12/14/2017 20:55:19 ******/
CREATE DATABASE [BMSBase] ON  PRIMARY 
( NAME = N'BMSBase', FILENAME = N'E:\BMSBase.mdf' , SIZE = 3072KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'BMSBase_log', FILENAME = N'E:\BMSBase_log.ldf' , SIZE = 1024KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO

ALTER DATABASE [BMSBase] SET COMPATIBILITY_LEVEL = 100
GO

IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [BMSBase].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO

ALTER DATABASE [BMSBase] SET ANSI_NULL_DEFAULT OFF 
GO

ALTER DATABASE [BMSBase] SET ANSI_NULLS OFF 
GO

ALTER DATABASE [BMSBase] SET ANSI_PADDING OFF 
GO

ALTER DATABASE [BMSBase] SET ANSI_WARNINGS OFF 
GO

ALTER DATABASE [BMSBase] SET ARITHABORT OFF 
GO

ALTER DATABASE [BMSBase] SET AUTO_CLOSE OFF 
GO

ALTER DATABASE [BMSBase] SET AUTO_CREATE_STATISTICS ON 
GO

ALTER DATABASE [BMSBase] SET AUTO_SHRINK OFF 
GO

ALTER DATABASE [BMSBase] SET AUTO_UPDATE_STATISTICS ON 
GO

ALTER DATABASE [BMSBase] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO

ALTER DATABASE [BMSBase] SET CURSOR_DEFAULT  GLOBAL 
GO

ALTER DATABASE [BMSBase] SET CONCAT_NULL_YIELDS_NULL OFF 
GO

ALTER DATABASE [BMSBase] SET NUMERIC_ROUNDABORT OFF 
GO

ALTER DATABASE [BMSBase] SET QUOTED_IDENTIFIER OFF 
GO

ALTER DATABASE [BMSBase] SET RECURSIVE_TRIGGERS OFF 
GO

ALTER DATABASE [BMSBase] SET  DISABLE_BROKER 
GO

ALTER DATABASE [BMSBase] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO

ALTER DATABASE [BMSBase] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO

ALTER DATABASE [BMSBase] SET TRUSTWORTHY OFF 
GO

ALTER DATABASE [BMSBase] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO

ALTER DATABASE [BMSBase] SET PARAMETERIZATION SIMPLE 
GO

ALTER DATABASE [BMSBase] SET READ_COMMITTED_SNAPSHOT OFF 
GO

ALTER DATABASE [BMSBase] SET HONOR_BROKER_PRIORITY OFF 
GO

ALTER DATABASE [BMSBase] SET  READ_WRITE 
GO

ALTER DATABASE [BMSBase] SET RECOVERY FULL 
GO

ALTER DATABASE [BMSBase] SET  MULTI_USER 
GO

ALTER DATABASE [BMSBase] SET PAGE_VERIFY CHECKSUM  
GO

ALTER DATABASE [BMSBase] SET DB_CHAINING OFF 
GO

USE [BMSBase]
GO

/****** Object:  Table [dbo].[tb_user]    Script Date: 12/14/2017 21:02:54 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

SET ANSI_PADDING ON
GO

CREATE TABLE [dbo].tb_operator(
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Name] [varchar](6) NOT NULL,
	[Sex] [varchar](2) NOT NULL,
	[Age] [int] NOT NULL,
	[Identitycard] [varchar](20) NOT NULL,
	[Workdate] [datetime] NOT NULL,
	[Tel] [varchar](15) NOT NULL,
	[Password] [nvarchar](10) NOT NULL,
	[Admin] [int]NOT NULL,
 CONSTRAINT [PK_tb_user] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]

CREATE TABLE [dbo].[tb_bookType](
	[TypeName] [varchar](20) NOT NULL,
	[Id] [int] IDENTITY(1,1) NOT NULL,
 CONSTRAINT [PK_tb_bookType] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]

CREATE TABLE [dbo].[tb_reader](
	[Name] [varchar](20) NOT NULL,
	[Sex] [varchar](2) NOT NULL,
	[Age] [int] NOT NULL,
	[IdentityCard] [varchar](30) NOT NULL,
	[Date] [smalldatetime] NOT NULL,
	[MaxNum] [int] NOT NULL,
	[Tel] [varchar](15) NOT NULL,
	[KeepMoney] [money] NOT NULL,
	[Zj] [varchar](10) NOT NULL,
	[Zy] [varchar](50) NOT NULL,
	[ISBN] [varchar](13) NOT NULL,
	[Bztime] [datetime] NOT NULL
) ON [PRIMARY]

CREATE TABLE [dbo].[tb_bookInfo](
	[ISBN] [varchar](13) NOT NULL,
	[Typeid] [int] NOT NULL,
	[Bookname] [varchar](60) NOT NULL,
	[Writer] [varchar](21) NOT NULL,
	[Translator] [varchar](30) NULL,
	[Publisher] [varchar](50),
	[Date] [smalldatetime] NOT NULL,
	[Price] [money] NOT NULL,
 CONSTRAINT [PK_tb_bookInfo] PRIMARY KEY CLUSTERED 
(
	[ISBN] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]

SET ANSI_PADDING OFF
GO





