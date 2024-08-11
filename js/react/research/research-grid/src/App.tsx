// App.tsx
import * as React from "react";
import { render } from "react-dom";
import { ReactGrid, Column, Row } from "@silevis/reactgrid";
import "@silevis/reactgrid/styles.css";

// Define some data to display in the grid
interface Person {
  name: string;
  surname: string;
}

const getPeople = (): Person[] => [
  { name: "Thomas", surname: "Goldman" },
  { name: "Susie", surname: "Quattro" },
  { name: "", surname: "" }
];

const getColumns = (): Column[] => [
  { columnId: "name", width: 150 },
  { columnId: "surname", width: 150 }
];

const headerRow: Row = {
  rowId: "header",
  cells: [
    { type: "header", text: "Name" },
    { type: "header", text: "Surname" }
  ]
};

// Generate your rows
const getRows = (people: Person[]): Row[] => [
  headerRow,
  ...people.map<Row>((person, idx) => ({
    rowId: idx,
    cells: [
      { type: "text", text: person.name },
      { type: "text", text: person.surname }
    ]
  }))
];

// Pass the data to ReactGrid
export function App() {
  const [people] = React.useState<Person[]>(getPeople());

  const rows = getRows(people);
  const columns = getColumns();

  return <ReactGrid rows={rows} columns={columns} />;
}

render(<App />, document.getElementById("root"));
