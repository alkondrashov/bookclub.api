CREATE TABLE TRANSACTION (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  merchantId Int,
  acquirerId Int,
  paymentMethod varchar(32),
  status varchar(64),
  errorCode varchar(64),
  PRIMARY KEY (id)
);

CREATE TABLE USER (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  password varchar(255) NOT NULL,
  username varchar(255) NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE CUSTOMER(
  id bigint(20) NOT NULL AUTO_INCREMENT,
   customerInfo_id             INTEGER  NOT NULL 
  ,customerInfocreated_at     VARCHAR(19) NOT NULL
  ,customerInfoupdated_at     VARCHAR(19) NOT NULL
  ,customerInfodeleted_at     VARCHAR(30)
  ,customerInfonumber         VARCHAR(16) NOT NULL
  ,customerInfoexpiryMonth    INTEGER  NOT NULL
  ,customerInfoexpiryYear     INTEGER  NOT NULL
  ,customerInfostartMonth     VARCHAR(30)
  ,customerInfostartYear      VARCHAR(30)
  ,customerInfoissueNumber    VARCHAR(30)
  ,customerInfoemail          VARCHAR(17) NOT NULL
  ,customerInfobirthday       VARCHAR(19) NOT NULL
  ,customerInfogender         VARCHAR(30)
  ,customerInfobillingTitle   VARCHAR(30)
  ,customerInfoAuthorization  VARCHAR(204) NOT NULL
  ,billingFirstName           VARCHAR(30) NOT NULL
  ,billingLastName            VARCHAR(30) NOT NULL
  ,billingCompany             VARCHAR(30)
  ,billingAddress1            VARCHAR(12) NOT NULL
  ,billingAddress2            VARCHAR(30)
  ,billingCity                VARCHAR(30) NOT NULL
  ,billingPostcode            INTEGER  NOT NULL
  ,billingState               VARCHAR(30)
  ,billingCountry             VARCHAR(3) NOT NULL
  ,billingPhone               VARCHAR(30)
  ,billingFax                 VARCHAR(30)
  ,shippingTitle              VARCHAR(30)
  ,shippingFirstName          VARCHAR(30) NOT NULL
  ,shippingLastName           VARCHAR(30) NOT NULL
  ,shippingCompany            VARCHAR(30)
  ,shippingAddress1           VARCHAR(12) NOT NULL
  ,shippingAddress2           VARCHAR(30)
  ,shippingCity               VARCHAR(30) NOT NULL
  ,shippingPostcode           INTEGER  NOT NULL
  ,shippingState              VARCHAR(30)
  ,shippingCountry            VARCHAR(2) NOT NULL
  ,shippingPhone              VARCHAR(30)
  ,shippingFax                VARCHAR(30)
);

