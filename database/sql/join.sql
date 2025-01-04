select t.id, op.status from test.tank as t JOIN test.tank_operation as op ON t.operation_id = op.tank_operation_id;
