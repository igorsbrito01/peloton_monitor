package br.ufc.pelotonmonitor.services;

import java.io.File;
import java.lang.management.ManagementFactory;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PagesService {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView getData() {

		ModelAndView model = new ModelAndView("home");

		return model;

	}

	public Map<String, Object> diskInfo() {
		
		File[] roots = File.listRoots();
		Map<String, Object> map = new HashMap<>();

		// Funciona caso tenha só 1 disco no PC, no caso na máquina virtual,
		// caso contrário tem que colocar qual disco tem que buscar o espaço disponível.
		for (File root : roots) {
			// map.put("totalDiskSpace", root.getTotalSpace()/1024/1024/1024);
			// map.put("freeDiskSpace", root.getFreeSpace()/1024/1024.0/1024);
			long usableSpace = root.getUsableSpace();
			long totalSpace = root.getTotalSpace();
			map.put("diskUsed", totalSpace - usableSpace);
			map.put("usableDiskSpace", usableSpace);
		}

		return map;
	}

	@SuppressWarnings("restriction")
	@RequestMapping(value = "/graphics", method = RequestMethod.GET)
	public ModelAndView getGraphics() {

		long memSize = ((com.sun.management.OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean())
				.getTotalPhysicalMemorySize();

		long freeMemSize = ((com.sun.management.OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean())
				.getFreePhysicalMemorySize();

		long memUsage = memSize - freeMemSize;

		double cpuUsage = ((com.sun.management.OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean())
				.getSystemCpuLoad() * 100;

		double freeCpu = 100.0 - cpuUsage;

		System.out
				.println("Total physical memory size: " + memSize + "\t in gb: " + memSize / 1024.0 / 1024.0 / 1024.0);
		System.out.println("Physical memory used: " + memUsage + "\t in gb: " + memUsage / 1024.0 / 1024.0 / 1024.0);
		System.out.println(
				"Free physical memory size: " + freeMemSize + "\t in gb: " + freeMemSize / 1024.0 / 1024.0 / 1024.0);
		System.out.println(cpuUsage * 100);

		ModelAndView model = new ModelAndView("graphics");
		Map<String, Object> map = new HashMap<>();
		map.put("memSize", memSize);
		map.put("freeMemSize", freeMemSize);
		map.put("memUsage", memUsage);
		map.put("cpuUsage", cpuUsage);
		map.put("freeCpu", freeCpu);
		map.putAll(diskInfo());
		model.addAllObjects(map);

		return model;

	}

	/*
	 * @RequestMapping(value="/teste/{foo}", method=RequestMethod.GET,
	 * produces="application/json") public @ResponseBody String
	 * byParameter(@PathVariable String foo) { //Perform logic with foo
	 * System.out.println(foo);
	 * 
	 * return "{nome:teste5}"; }
	 */
}