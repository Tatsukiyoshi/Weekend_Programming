; ModuleID = 'aggregate.c'
source_filename = "aggregate.c"
target datalayout = "e-m:e-p270:32:32-p271:32:32-p272:64:64-i64:64-f80:128-n8:16:32:64-S128"
target triple = "x86_64-pc-linux-gnu"

%struct.hoge2 = type { i8, double, %struct.hoge1 }
%struct.hoge1 = type { float, [10 x [20 x i32]] }

; Function Attrs: noinline nounwind optnone uwtable
define dso_local i32* @getelem(%struct.hoge2* %0) #0 {
  %2 = alloca %struct.hoge2*, align 8
  store %struct.hoge2* %0, %struct.hoge2** %2, align 8
  %3 = load %struct.hoge2*, %struct.hoge2** %2, align 8
  %4 = getelementptr inbounds %struct.hoge2, %struct.hoge2* %3, i64 1
  %5 = getelementptr inbounds %struct.hoge2, %struct.hoge2* %4, i32 0, i32 2
  %6 = getelementptr inbounds %struct.hoge1, %struct.hoge1* %5, i32 0, i32 1
  %7 = getelementptr inbounds [10 x [20 x i32]], [10 x [20 x i32]]* %6, i64 0, i64 5
  %8 = getelementptr inbounds [20 x i32], [20 x i32]* %7, i64 0, i64 13
  ret i32* %8
}

attributes #0 = { noinline nounwind optnone uwtable "correctly-rounded-divide-sqrt-fp-math"="false" "disable-tail-calls"="false" "frame-pointer"="all" "less-precise-fpmad"="false" "min-legal-vector-width"="0" "no-infs-fp-math"="false" "no-jump-tables"="false" "no-nans-fp-math"="false" "no-signed-zeros-fp-math"="false" "no-trapping-math"="false" "stack-protector-buffer-size"="8" "target-cpu"="x86-64" "target-features"="+cx8,+fxsr,+mmx,+sse,+sse2,+x87" "unsafe-fp-math"="false" "use-soft-float"="false" }

!llvm.module.flags = !{!0}
!llvm.ident = !{!1}

!0 = !{i32 1, !"wchar_size", i32 4}
!1 = !{!"clang version 10.0.0-4ubuntu1 "}
