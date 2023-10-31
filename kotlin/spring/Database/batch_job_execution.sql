-- Table: public.batch_job_execution

-- DROP TABLE IF EXISTS public.batch_job_execution;

CREATE TABLE IF NOT EXISTS public.batch_job_execution
(
    job_execution_id bigint UNIQUE NOT NULL,
    version bigint,
    job_instance_id bigint NOT NULL,
    create_time timestamp without time zone NOT NULL,
    start_time timestamp without time zone,
    end_time timestamp without time zone,
    status character varying(10) COLLATE pg_catalog."default",
    exit_code character varying(2500) COLLATE pg_catalog."default",
    exit_message character varying(2500) COLLATE pg_catalog."default",
    last_updated timestamp without time zone
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.batch_job_execution
    OWNER to spring;