-- Table: public.batch_step_execution

-- DROP TABLE IF EXISTS public.batch_step_execution;

CREATE TABLE IF NOT EXISTS public.batch_step_execution
(
    step_execution_id bigint NOT NULL,
    version bigint NOT NULL,
    step_name character varying(100) COLLATE pg_catalog."default" NOT NULL,
    job_execution_id bigint NOT NULL,
    create_time timestamp not null default '1970-01-01 00:00:00',
    start_time timestamp without time zone,
    end_time timestamp without time zone,
    status character varying(10) COLLATE pg_catalog."default",
    commit_count bigint,
    read_count bigint,
    filter_count bigint,
    write_count bigint,
    read_skip_count bigint,
    write_skip_count bigint,
    process_skip_count bigint,
    rollback_count bigint,
    exit_code character varying(2500) COLLATE pg_catalog."default",
    exit_message character varying(2500) COLLATE pg_catalog."default",
    last_updated timestamp without time zone,
    CONSTRAINT batch_step_execution_pkey PRIMARY KEY (step_execution_id),
    CONSTRAINT job_exec_step_fk FOREIGN KEY (job_execution_id)
        REFERENCES public.batch_job_execution (job_execution_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.batch_step_execution
    OWNER to spring;