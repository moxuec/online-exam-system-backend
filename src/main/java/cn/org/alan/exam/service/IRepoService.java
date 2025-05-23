package cn.org.alan.exam.service;

import cn.org.alan.exam.common.result.Result;
import cn.org.alan.exam.model.entity.Repo;
import cn.org.alan.exam.model.vo.repo.RepoListVO;
import cn.org.alan.exam.model.vo.repo.RepoVO;
import cn.org.alan.exam.model.vo.exercise.ExerciseRepoVO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * 题库管理服务接口
 *
 * @author WeiJin
 * @since 2024-03-21
 */
public interface IRepoService extends IService<Repo> {

    /**
     * 添加题库
     *
     * @param repo 参数
     * @return 返回
     */
    Result<String> addRepo(Repo repo);

    /**
     * 修改题库
     *
     * @param repo 修改内容
     * @param id   路径参数题库id
     * @return 返回响应结果
     */
    Result<String> updateRepo(Repo repo, Integer id);

    /**
     * 根据题库id删除题库 并把试题所属题库清空
     *
     * @param id 题库id
     * @return 响应返回结果
     */
    Result<String> deleteRepoById(Integer id);

    /**
     * 根据用户id获取自己的题库 教师获取自己的，管理员可以获取所有
     *
     * @param repoTitle 题库名称
     * @return 响应结果
     */
    Result<List<RepoListVO>> getRepoList(String repoTitle);

    /**
     * 分页查询题库
     *
     * @param pageNum    页码
     * @param pageSize   每页记录数
     * @param title      标题
     * @param categoryId 分类ID
     * @return 返回结果响应
     */
    Result<IPage<RepoVO>> pagingRepo(Integer pageNum, Integer pageSize, String title, Integer categoryId);

    /**
     * 分页获取可刷题库列表
     *
     * @param pageNum    页码
     * @param pageSize   每页记录数
     * @param title      题库名
     * @param categoryId 分类ID
     * @return 响应结果
     */
    Result<IPage<ExerciseRepoVO>> getRepo(Integer pageNum, Integer pageSize, String title, Integer categoryId);
    
    /**
     * 按分类查询题库的方法
     */
    Result<IPage<RepoVO>> getReposByCategory(Integer categoryId, Integer pageNum, Integer pageSize);
    
}
