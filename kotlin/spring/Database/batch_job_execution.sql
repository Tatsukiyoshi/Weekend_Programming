-- Table: public.batch_job_execution

-- DROP TABLE IF EXISTS public.batch_job_execution;

CREATE TABLE IF NOT EXISTS public.batch_job_execution
(
    job_execution_id bigint NOT NULL,
    version bigint,
    job_instance_id bigint NOT NULL,
    create_time timestamp without time zone NOT NULL,
    start_time timestamp without time zone,
    end_time timestamp without time zone,
    status character varying(10) COLLATE pg_catalog."default",
    exit_code character varying(2500) COLLATE pg_catalog."default",
    exit_message character varying(2500) COLLATE pg_catalog."default",
    last_updated timestamp without time zone,
    job_configuration_location character varying(2500) COLLATE pg_catalog."default",
    CONSTRAINT batch_job_execution_pkey PRIMARY KEY (job_execution_id),
    CONSTRAINT job_inst_exec_fk FOREIGN KEY (job_instance_id)
        REFERENCES public.batch_job_instance (job_instance_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.batch_job_execution
    OWNER to spring;