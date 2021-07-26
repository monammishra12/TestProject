CREATE TABLE public.customer
(
    customer_id bigint NOT NULL, 
    create_date timestamp without time zone,
    email character varying(255) COLLATE pg_catalog."default",
    first_name character varying(255) COLLATE pg_catalog."default",
    last_name character varying(255) COLLATE pg_catalog."default",
    password character varying(255) COLLATE pg_catalog."default",
    phone_number character varying(255) COLLATE pg_catalog."default",
    update_date timestamp without time zone,
    CONSTRAINT customer_pkey PRIMARY KEY (customer_id)
);


CREATE TABLE public.product_category
(
    category_id bigint NOT NULL ,
    category_name character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT product_category_pkey PRIMARY KEY (category_id)
);


CREATE TABLE public.products
(
    product_id bigint NOT NULL ,
    date date,
    discount_percent double precision,
    discount_price double precision,
    product_description character varying(255) COLLATE pg_catalog."default",
    product_name character varying(255) COLLATE pg_catalog."default",
    product_price double precision,
    available_quantity bigint,
    category_id bigint,
    CONSTRAINT products_pkey PRIMARY KEY (product_id),
    CONSTRAINT fk1bfbbw5vei53vhmynbdfxq50n FOREIGN KEY (category_id)
        REFERENCES public.product_category (category_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);


CREATE TABLE public.address
(
    address_id bigint NOT NULL,
    area character varying(255) COLLATE pg_catalog."default",
    building_name character varying(255) COLLATE pg_catalog."default",
    city character varying(255) COLLATE pg_catalog."default",
    house_no character varying(255) COLLATE pg_catalog."default",
    landmark character varying(255) COLLATE pg_catalog."default",
    pincode character varying(255) COLLATE pg_catalog."default",
    state character varying(255) COLLATE pg_catalog."default",
    street character varying(255) COLLATE pg_catalog."default",
    category_id bigint,
    CONSTRAINT address_pkey PRIMARY KEY (address_id),
    CONSTRAINT fkiuo5sfw9rsyehwbfclmxdoaxm FOREIGN KEY (category_id)
        REFERENCES public.customer (customer_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);