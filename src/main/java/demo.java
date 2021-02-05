


public class demo {
    public static void main(String[] args) {

//
//
//
//        StringBuilder sb = new StringBuilder();
//        StringBuilder sb1 = new StringBuilder();
//        System.out.println("hello");
//        if (CollectionUtils.isEmpty(this.selectList)) {
//            return "";
//        }
//
//        boolean isSql = false;
//        String dataRuleSql = "";
//        if (CollectionUtils.isNotEmpty(this.whereList)) {
//            for (int i = 0; i < this.whereList.size(); i++) {
//                if (this.whereList.get(i).contains("EXISTS")) {
//                    isSql = true;
//                    dataRuleSql = this.whereList.get(i);
//                    break;
//                }
//
//            }
//        }
//
//        if (checkSelectMap(this.selectMap)) {
//            return toSqlWithWindowFun();
//        }
//
//        if (ListUtil.isNotBlank(this.getSubTableQueries())) {
//            sb.append(toSqlWithSubQueries());
//        }
//
//        if (checkSelectMapUseSubQuery(this.selectMap)) {
//            sb.append(toSqlWithChildQueries(this));
//            if (StringUtils.isNotBlank(this.getSub_S_Child())) {
//                this.getTableRelations().clear();
//                this.groupBy.clear();
//                this.whereList.clear();
//                this.notNullList.clear();
//            }
//        }
//
//
//        if (this.selectList != null) {
//            sb.append("select ");
//            if (this.distinct) {
//                sb.append(" distinct ");
//            }
//            String selectExpresstion = "";
//            Set<ColumnField> treeColumns = Sets.newLinkedHashSet();
//            for (int i = 0; i < selectList.size(); i++) {
//                ColumnField select = selectList.get(i);
//                if (this.getExportTreeColumnFields().contains(select)) {
//                    if (StringUtils.isNotBlank(this.getSub_S_Child())) {
//                        treeColumns.add(new ColumnField(this.getSub_S_Child() + "." + select.getAlias().replace(".", "_"), this.getSub_S_Child() + "." + select.getAlias().replace(".", "_")));
//                    } else {
//                        treeColumns.add(new ColumnField(select.getFieldname(), select.getAlias()));
//                    }
//                }
//                if ("grouping".equals(select.getAlias())) {
//                    continue;
//                }
//
//                if (selectMap.get(select.getFieldname()).getOperator() == null) {
//                    if (StringUtils.isNotBlank(this.getSub_S_Child())) {
//                        selectExpresstion = selectExpresstion + " " + this.getSub_S_Child() + "." + select.getAlias().replace(".", "_") + " as " + select.getAlias().replace(".", "_") + ",";
//                        if (select.getFieldname().endsWith("wide_column0")) {
//                            this.notNullList.add(this.getSub_S_Child() + "." + select.getAlias().replace(".", "_"));
//                        }
//
//                    } else {
//                        selectExpresstion = selectExpresstion + select.getFieldname() + " as " + select.getAlias().replace(".", "_") + ",";
//                    }
//                    if (StringUtils.isNotBlank(this.getSub_F_Child())) {
//                        this.getSubTableRelations().add(buildTableRelationBySubTable(select, this.getSub_F_Child(), this.getSub_S_Child()));
//                    }
//                    if (StringUtils.isNotBlank(this.getSub_L_Child())) {
//                        this.getSubTableRelations().add(buildTableRelationBySubTable(select, this.getSub_L_Child(), this.getSub_S_Child()));
//                    }
//                } else {
//                    if (ListUtil.isNotBlank(this.getSubTableQueries())) {
//                        if (StringUtils.isNotBlank(this.getSub_F_Child())) {
//                            if ("SUMFIRSTCHILD".equals(selectMap.get(select.getFieldname()).getOperator())) {
//                                selectExpresstion = selectExpresstion + " " + this.getSub_F_Child() + "." + select.getAlias().replace(".", "_") + " as " + select.getAlias().replace(".", "_") + ",";
//                                this.getGroupBy().add(new ColumnField(this.getSub_F_Child() + "." + select.getAlias().replace(".", "_"), this.getSub_F_Child() + "." + select.getAlias().replace(".", "_")));
//                            } else {
//                                selectExpresstion = selectExpresstion + buildSelectExpresstion(this, selectMap.get(select.getFieldname()).getOperator(), select);
//                            }
//                        } else if (StringUtils.isNotBlank(this.getSub_L_Child())) {
//                            if ("SUMLASTCHILD".equals(selectMap.get(select.getFieldname()).getOperator())) {
//                                selectExpresstion = selectExpresstion + " " + this.getSub_L_Child() + "." + select.getAlias().replace(".", "_") + " as " + select.getAlias().replace(".", "_") + ",";
//                                this.getGroupBy().add(new ColumnField(this.getSub_L_Child() + "." + select.getAlias().replace(".", "_"), this.getSub_L_Child() + "." + select.getAlias().replace(".", "_")));
//                            } else {
//                                selectExpresstion = selectExpresstion + buildSelectExpresstion(this, selectMap.get(select.getFieldname()).getOperator(), select);
//                            }
//                        } else {
//                            selectExpresstion = selectExpresstion + buildSelectExpresstion(this, selectMap.get(select.getFieldname()).getOperator(), select);
//                        }
//                    } else {
//                        if ((this.isNeedtotal() || this.isNeedsubtotal()) && "SUMFIRSTCHILD".equals(selectMap.get(select.getFieldname()).getOperator())) {
//                            selectExpresstion = selectExpresstion + " " + this.getSub_F_Child() + "." + select.getAlias().replace(".", "_") + " as " + select.getAlias().replace(".", "_") + ",";
//                        } else if ((this.isNeedtotal() || this.isNeedsubtotal()) && "SUMLASTCHILD".equals(selectMap.get(select.getFieldname()).getOperator())) {
//                            selectExpresstion = selectExpresstion + " " + this.getSub_L_Child() + "." + select.getAlias().replace(".", "_") + " as " + select.getAlias().replace(".", "_") + ",";
//                        } else if ("SUMFIRSTCHILD".equals(selectMap.get(select.getFieldname()).getOperator())) {
//                            selectExpresstion = selectExpresstion + " " + Aggregator.MAX.getName() + "(" + this.getSub_F_Child() + "." + select.getAlias().replace(".", "_") + ") as " + select.getAlias().replace(".", "_") + ",";
//
//                        } else if ("SUMLASTCHILD".equals(selectMap.get(select.getFieldname()).getOperator())) {
//                            selectExpresstion = selectExpresstion + " " + Aggregator.MAX.getName() + "(" + this.getSub_L_Child() + "." + select.getAlias().replace(".", "_") + ") as " + select.getAlias().replace(".", "_") + ",";
//
//                        } else {
//                            if (StringUtils.isNotBlank(this.getSub_L_Child()) && selectMap.get(select.getFieldname()).getOperator().equals(Aggregator.NONE.getName())) {
//                                this.getSubTableRelations().add(buildTableRelationBySubTable(select, this.getSub_L_Child(), this.getSub_S_Child()));
//                            }
//                            if (StringUtils.isNotBlank(this.getSub_F_Child()) && selectMap.get(select.getFieldname()).getOperator().equals(Aggregator.NONE.getName())) {
//                                this.getSubTableRelations().add(buildTableRelationBySubTable(select, this.getSub_F_Child(), this.getSub_S_Child()));
//                            }
//                            if (StringUtils.isNotBlank(this.getSub_S_Child()) && !selectMap.get(select.getFieldname()).getOperator().equals(Aggregator.NONE.getName())) {
//                                selectExpresstion = buildSubExportExpression(selectExpresstion, select);
//
//                            } else {
//                                if (StringUtils.isNotBlank(this.getSub_S_Child())) {
//
//                                    selectExpresstion = selectExpresstion + " " + this.getSub_S_Child() + "." + select.getAlias().replace(".", "_") + " as " + select.getAlias().replace(".", "_") + ",";
//
//                                } else {
//                                    selectExpresstion = selectExpresstion + buildSelectExpresstion(this, selectMap.get(select.getFieldname()).getOperator(), select);
//                                }
//                            }
//
//                        }
//                    }
//
//
//                }
//            }
//
//
//
//        }
//        return sb.toString();
//





    }

}
