import * as d3 from "d3";
import { useEffect, useRef } from "react";

export default function LinePlot({
  data,
  width = 640,
  height = 400,
  marginTop = 20,
  marginRight = 20,
  marginBottom = 20,
  marginLeft = 20
}: {
  data: number[];
  width?: number;
  height?: number;
  marginTop?: number;
  marginRight?: number;
  marginBottom?: number;
  marginLeft?: number;
}) {
  const gx = useRef<SVGGElement>(null);
  const gy = useRef<SVGGElement>(null);
  const x = d3.scaleLinear([0, data.length - 1], [marginLeft, width - marginRight]);
  const extent = d3.extent(data) as [number, number] | undefined;
  const y = d3.scaleLinear(extent || [0, 1], [height - marginBottom, marginTop]);
  const line = d3.line((_d: any, i: any) => x(i), y).curve(d3.curveNatural);
  useEffect(() => {
    if (gx.current) {
      d3.select(gx.current).call(d3.axisBottom(x));
    }
  }, [x]);

  useEffect(() => {
    if (gy.current) {
      d3.select(gy.current).call(d3.axisLeft(y));
    }
  }, [y]);
  return (
    <svg width={width} height={height}>
      <g ref={gx} transform={`translate(0,${height - marginBottom})`} />
      <g ref={gy} transform={`translate(${marginLeft},0)`} />
      <path fill="none" stroke="currentColor" strokeWidth="1.5" d={line(data) || ""} />
      <g fill="white" stroke="currentColor" strokeWidth="1.5">
        {data.map((d: number, i: number) => (<circle key={i} cx={x(i)} cy={y(d)} r="2.5" />))}
      </g>
    </svg>
  );
}