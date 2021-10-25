package com.sc.study;

import lombok.Data;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * @author yingqi
 * @version 1.0
 * @date 2021/10/25 4:44 下午
 * @desc
 */
public class loadbalance {
    public static void main(String[] args) {
        List<EntityNode> entityList = new ArrayList<EntityNode>();
        entityList.add(new EntityNode("A", 2));
        entityList.add(new EntityNode("B", 3));
        entityList.add(new EntityNode("C", 500));
        for (int i = 0; i < 10; i++) {
            System.out.println(roundRobinEntity(entityList));
        }
    }

    private static final HashMap<String, EntityNode> ENTITY_NODE_WEIGHT = new HashMap<>();

    /**
     * 带权重（平滑加权）的轮循负载均衡算法
     * 思想:1：每经过一次轮询每个节点的currentWeight会加上自己的原生权重
     * 2：被选中的节点的currentWeight要减去所有节点的所有原生权重之后
     * 3：依次按照前两步的思想进行筛选
     * 注意：如果两个currentWeight值相同的节点按顺序进行选取
     *
     * @return
     */
    private static EntityNode roundRobinEntity(List<EntityNode> entityList) {
        if (entityList.isEmpty()) {
            return null;
        }
        synchronized (ENTITY_NODE_WEIGHT) {
            //初始化数据
            entityList.forEach(item -> {
                ENTITY_NODE_WEIGHT.put(item.getName(), item);
            });
            //计算总权重值
            int totalWeight = 0;
            for (EntityNode node : ENTITY_NODE_WEIGHT.values()) {
                totalWeight += node.getWeight();
            }
            //每经过一次轮询每个节点的currentWeight会加上自己的原生权重
            for (EntityNode node : ENTITY_NODE_WEIGHT.values()) {
                node.setCurrentWeight(node.getCurrentWeight() + node.getWeight());
            }
            //选出当前权重最大的节点
            EntityNode maxCurrentWeightNode = null;
            for (EntityNode node : ENTITY_NODE_WEIGHT.values()) {
                if (maxCurrentWeightNode == null || node.getCurrentWeight() > maxCurrentWeightNode.getCurrentWeight()) {
                    maxCurrentWeightNode = node;
                }
            }
            if (null == maxCurrentWeightNode) {
                return null;
            }
            //将选中的节点的当前权重减去权重总和
            maxCurrentWeightNode.setCurrentWeight(maxCurrentWeightNode.getCurrentWeight() - totalWeight);
            return maxCurrentWeightNode;
        }
    }

    /**
     * 带权重的随机负载均衡算法
     *
     * @param entityList
     * @return
     */
    private static EntityNode randomEntry(List<EntityNode> entityList) {
        if (CollectionUtils.isEmpty(entityList)) {
            return null;
        }
        //判断一次所有的节点权重是否一致
        boolean weightIsSame = true;
        int firstWeight = entityList.get(0).getWeight();
        for (int i = 1; i < entityList.size(); i++) {
            if (firstWeight != entityList.get(i).getWeight()) {
                weightIsSame = false;
                break;
            }
        }
        Random random = new Random();
        if (weightIsSame) {
            //若节点权重一致，只需要采用简单的随机算法即可
            return entityList.get(random.nextInt(entityList.size()));
        } else {
            //不一致，则考虑带权重的随机
            int totalWeight = 0;
            for (EntityNode entity : entityList) {
                totalWeight += entity.getWeight();
            }
            for (EntityNode entity : entityList) {
                int currentRandomNum = random.nextInt(totalWeight);
                if (currentRandomNum < entity.getWeight()) {
                    return entity;
                } else {
                    totalWeight -= currentRandomNum;
                }
            }
            return null;
        }
    }

    @Data
    static class EntityNode {
        /**
         * 名称
         */
        String name;
        /**
         * 权重
         */
        int weight;

        /**
         * 时时权重
         */
        int currentWeight;

        public EntityNode(String name, int weight) {
            this.name = name;
            this.weight = weight;
            this.currentWeight = 0;
        }
    }

}


