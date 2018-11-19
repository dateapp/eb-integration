
-- Drop table

-- DROP TABLE public.eb_event

CREATE TABLE public.eb_event (
	description text NULL,
	eb_name text NULL,
	eb_url varchar NULL,
	eb_id int8 NOT NULL,
	event_timezone varchar NULL,
	event_start_time timestamp NULL,
	event_end_time timestamp NULL,
	eb_organization_id int8 NULL,
	status varchar NULL,
	online_event bool NULL,
	is_free bool NULL,
	venue_id int8 NULL,
	category_id int4 NOT NULL,
	subcategory_id varchar NULL,
	eb_image_url varchar NULL,
	state varchar(2) NULL,
	display_address varchar NULL,
	multiline_display_address text NULL,
	zip_code varchar(10) NULL,
	latitude numeric(7) NULL,
	longitude numeric(7) NULL,
	venue_name text NULL,
	address1 varchar NULL,
	address2 varchar NULL,
	country varchar NULL,
	city varchar NULL
);
COMMENT ON TABLE public.eb_event IS 'Events from EventBrite Integration';

-- Permissions

ALTER TABLE public.eb_event OWNER TO root;
GRANT ALL ON TABLE public.eb_event TO root;



CREATE TABLE public.eb_categories (
	category_id integer NOT NULL,
	category_name varchar NULL,
	CONSTRAINT eb_categories_pk PRIMARY KEY (categoryid)
);
COMMENT ON TABLE public.eb_categories IS 'EventBrite Integration Categories';


INSERT INTO public.eb_categories (categoryid, categoryname) VALUES(103, 'Music');
INSERT INTO public.eb_categories (categoryid, categoryname) VALUES(101, 'Business & Professional');	
INSERT INTO public.eb_categories (categoryid, categoryname) VALUES(110, 'Food & Drink');	
INSERT INTO public.eb_categories (categoryid, categoryname) VALUES(113, 'Community & Culture');
INSERT INTO public.eb_categories (categoryid, categoryname) VALUES(105, 'Performing & Visual Arts');
INSERT INTO public.eb_categories (categoryid, categoryname) VALUES(104, 'Film, Media & Entertainment');
INSERT INTO public.eb_categories (categoryid, categoryname) VALUES(108, 'Sports & Fitness');
INSERT INTO public.eb_categories (categoryid, categoryname) VALUES(107, 'Health & Wellness');
INSERT INTO public.eb_categories (categoryid, categoryname) VALUES(102, 'Science & Technology');
INSERT INTO public.eb_categories (categoryid, categoryname) VALUES(109, 'Travel & Outdoor');
INSERT INTO public.eb_categories (categoryid, categoryname) VALUES(111, 'Charity & Causes');
INSERT INTO public.eb_categories (categoryid, categoryname) VALUES(114, 'Religion & Spirituality');
INSERT INTO public.eb_categories (categoryid, categoryname) VALUES(115, 'Family & Education');
INSERT INTO public.eb_categories (categoryid, categoryname) VALUES(116, 'Seasonal & Holiday');
INSERT INTO public.eb_categories (categoryid, categoryname) VALUES(112, 'Government & Politics');
INSERT INTO public.eb_categories (categoryid, categoryname) VALUES(106, 'Fashion & Beauty');
INSERT INTO public.eb_categories (categoryid, categoryname) VALUES(117, 'Home & Lifestyle');
INSERT INTO public.eb_categories (categoryid, categoryname) VALUES(118, 'Auto, Boat & Air');
INSERT INTO public.eb_categories (categoryid, categoryname) VALUES(119, 'Hobbies & Special Interest');
INSERT INTO public.eb_categories (categoryid, categoryname) VALUES(199, 'Other');
INSERT INTO public.eb_categories (categoryid, categoryname) VALUES(120, 'School Activities');


