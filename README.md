Plan-Analyzer
=============
Dremio Plan Analyzer is a tool to parse and reformat the final phyical plan of a dremio query so that it can be easier to be analyzed.

The input format of the physical plan is

```
00-00    Screen : rowType = RecordType(VARCHAR(65536) Fragment, BIGINT Records, VARCHAR(65536) Path, VARBINARY(65536) Metadata, INTEGER Partition, BIGINT FileSize, VARBINARY(65536) IcebergMetadata): rowcount = 2.6573941131831463E10, cumulative cost = {1.0317927805105938E16 rows, 1.03095557475546842E18 cpu, 4.341373311E9 io, 5.8261581445578672E16 network, 1.8920627654918308E12 memory}, id = 85879783
00-01      Project(Fragment=[$0], Records=[$1], Path=[$2], Metadata=[$3], Partition=[$4], FileSize=[$5], IcebergMetadata=[$6]) : rowType = RecordType(VARCHAR(65536) Fragment, BIGINT Records, VARCHAR(65536) Path, VARBINARY(65536) Metadata, INTEGER Partition, BIGINT FileSize, VARBINARY(65536) IcebergMetadata): rowcount = 2.6573941131831463E10, cumulative cost = {1.0317925147711824E16 rows, 1.03095557209807424E18 cpu, 4.341373311E9 io, 5.8261581445578672E16 network, 1.8920627654918308E12 memory}, id = 85879782
00-02        WriterCommitter(final=[/fnma-drem-prod-edl-us-east-1-private/build/ec2/drem-ec2-03/drem_reflections/drem-prod-edl-alb-05/results/1c785cf1-2c74-f84d-6781-e1930808e300]) : rowType = RecordType(VARCHAR(65536) Fragment, BIGINT Records, VARCHAR(65536) Path, VARBINARY(65536) Metadata, INTEGER Partition, BIGINT FileSize, VARBINARY(65536) IcebergMetadata): rowcount = 2.6573941131831463E10, cumulative cost = {1.0317898573770692E16 rows, 1.03095557209621402E18 cpu, 4.341373311E9 io, 5.8261581445578672E16 network, 1.8920627654918308E12 memory}, id = 85879781
00-03          UnionExchange : rowType = RecordType(VARCHAR(65536) Fragment, BIGINT Records, VARCHAR(65536) Path, VARBINARY(65536) Metadata, INTEGER Partition, BIGINT FileSize, VARBINARY(65536) IcebergMetadata): rowcount = 2.6573941131831463E10, cumulative cost = {1.031787199982956E16 rows, 1.0309555455222729E18 cpu, 4.341373311E9 io, 5.8261581445578672E16 network, 1.8920627654918308E12 memory}, id = 85879780
                 ...
```
The list will be parsed by PlanParser into many plan lines in a list (non-hierarchical), and PlanUtils provides a way to fix the hierarchical structure of the plan into POJO PlanLine class that contains children PlanLines. Combining with the AST visitor, many different analyzers can be written to analyze the structure of PlanLine and the PlanLine AST. Each PlanLine also contains an information map which can be used to capture information during the analysis phase (see the analyzer for example)
> NOTE: This is done so due to some limitation in antlr to support recursive parsing (ran into StackOverflow with Antlr state machine). The advantage of the approach though is the parser can be language-independent.

There are a few examples of analyzers in this repo.
1. PlanPrinter - which takes a plan and reformat it in a various way using different PrintOptions
2. PlanAnalyzer - which parses and outputs the plan for join analysis


**Expression Parser**
----------
The attribute values in the plan are not parsed. Some of them contain complex expression (e.g. filter condition or projection function) and as a way to facilitate the resolve of these values, an expression parser is created so the late stage analysis can be done on the expression parser.
